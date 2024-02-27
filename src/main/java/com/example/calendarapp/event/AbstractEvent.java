package com.example.calendarapp.event;

import com.example.calendarapp.event.update.AbstractAuditableEvent;
import com.example.calendarapp.exception.InvalidEventException;

import java.time.Duration;
import java.time.ZonedDateTime;

/**
 * author : ms.Lee
 * date   : 2024-02-26
 */
public abstract class AbstractEvent implements Event {

  private final int id;
  private String title;

  private ZonedDateTime startAt;
  private ZonedDateTime endAt;
  private Duration duration;      // 편의를 위해

  private final ZonedDateTime createdAt;
  private ZonedDateTime modifiedAt;

  private boolean deleteYn;

  // 생성자
  protected AbstractEvent(
      int id,
      String title,
      ZonedDateTime startAt,
      ZonedDateTime endAt
  ) {

    // validation
    if (startAt.isAfter(endAt)) {

      throw new InvalidEventException(
          String.format(
              "시작일은 종료일보다 이전이어야 합니다. 시작일=%s, 종료일=%s",
              startAt,
              endAt
          )
      );
    }

    this.id = id;
    this.title = title;
    this.startAt = startAt;
    this.endAt = endAt;
    this.duration = Duration.between(startAt, endAt);

    ZonedDateTime now = ZonedDateTime.now();
    this.createdAt = now;
    this.modifiedAt = now;

    this.deleteYn = false;
  }

  // 수정에 대한 method 추가
  public void validateAndUpdate(AbstractAuditableEvent update) {

    if (deleteYn == true) {

      throw new RuntimeException("이미 삭제된 이벤트는 수정할 수 없음");
    }

    defaultUpdate(update);
    update(update);
  }

  // 공통으로 update되는 method
  private void defaultUpdate(AbstractAuditableEvent update) {

    this.title = update.getTitle();
    this.startAt = update.getStartAt();
    this.endAt = update.getEndAt();
    this.duration = Duration.between(this.startAt, this.endAt);
    this.modifiedAt = ZonedDateTime.now();
  }

  // 개별로 update 되는 method
  protected abstract void update(AbstractAuditableEvent update);

  // 삭제 추가
  public void delete(boolean deleteYn) {

    this.deleteYn = deleteYn;
  }

  public String getTitle() {

    return this.title;
  }

  public ZonedDateTime getStartAt() {

    return this.startAt;
  }

  public ZonedDateTime getEndAt() {

    return this.endAt;
  }
}
