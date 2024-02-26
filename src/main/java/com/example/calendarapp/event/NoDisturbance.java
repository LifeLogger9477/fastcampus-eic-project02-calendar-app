package com.example.calendarapp.event;

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
  public void print() {


  }

  @Override
  public boolean support(EventType type) {

    return type == EventType.NO_DISTURBANCE;
  }


}