package com.example.calendarapp.event.update;

import java.time.ZonedDateTime;

/**
 * author : ms.Lee
 * date   : 2024-02-27
 */
public abstract class AbstractAuditableEvent {

  private final String title;
  private final ZonedDateTime startAt;
  private final ZonedDateTime endAt;

  protected AbstractAuditableEvent(
      String title,
      ZonedDateTime startAt,
      ZonedDateTime endAt
  ) {

    this.title = title;
    this.startAt = startAt;
    this.endAt = endAt;
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
