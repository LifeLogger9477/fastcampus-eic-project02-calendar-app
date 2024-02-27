package com.example.calendarapp.event;

import com.example.calendarapp.event.update.AbstractAuditableEvent;

import java.time.ZonedDateTime;

/**
 * author : ms.Lee
 * date   : 2024-02-26
 */
public class Todo extends AbstractEvent {

  private String description;

  public Todo(
      int id,
      String title,
      ZonedDateTime startAt,
      ZonedDateTime endAt,
      String description
  ) {

    super(id, title, startAt, endAt);

    this.description = description;
  }

  @Override
  public void print() {

    System.out.printf("[할 일] %s : %s\n", getTitle(), description);
  }

  @Override
  public boolean support(EventType type) {

    return type == EventType.TO_DO;
  }

  @Override
  protected void update(AbstractAuditableEvent update) {

  }
}
