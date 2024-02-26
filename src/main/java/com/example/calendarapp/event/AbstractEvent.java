package com.example.calendarapp.event;

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

  public String getTitle() {

    return this.title;
  }
}
