package com.example.calendarapp.event;

import com.example.calendarapp.event.update.AbstractAuditableEvent;

import java.time.ZonedDateTime;

/**
 * author : ms.Lee
 * date   : 2024-02-26
 */
public class NoDisturbance extends AbstractEvent {

  public NoDisturbance(
      int id,
      String title,
      ZonedDateTime startAt,
      ZonedDateTime endAt
  ) {

    super(id, title, startAt, endAt);
  }

  @Override
  protected void update(AbstractAuditableEvent update) {

  }

  @Override
  public void print() {

    System.out.printf("[방해금지] %s\n", getTitle());
  }

  @Override
  public boolean support(EventType type) {

    return type == EventType.NO_DISTURBANCE;
  }


}
