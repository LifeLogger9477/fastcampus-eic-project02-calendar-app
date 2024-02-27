package com.example.calendarapp.event;

import com.example.calendarapp.event.update.AbstractAuditableEvent;

import java.time.ZonedDateTime;

/**
 * author : ms.Lee
 * date   : 2024-02-26
 */
public class OutOfOffice extends AbstractEvent {

  public OutOfOffice(
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


  }

  @Override
  public boolean support(EventType type) {

    return type == EventType.OUT_OFF_OFFICE;
  }
}
