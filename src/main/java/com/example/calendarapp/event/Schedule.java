package com.example.calendarapp.event;

import java.util.ArrayList;
import java.util.List;

/**
 * author : ms.Lee
 * date   : 2024-02-26
 */
// list 를 관리할 class
public class Schedule {

  private List<AbstractEvent> events = new ArrayList<>();

  public void add(AbstractEvent event) {

    if (hasScheduleConflictWith(event)) {

      return;
    }

    this.events.add(event);
  }

  // 전체 출력
  public void pringAll() {

    events.forEach(Event::print);
  }

  // 특정 타입만 출력
  public void printBy(EventType type) {

    events.stream()
        .filter(event -> event.support(type))
        .forEach(Event::print);
  }

  // 추가되는 이벤트 시작/종료시간이 기존 시작/종료시간과 겹치는가?
  private boolean hasScheduleConflictWith(AbstractEvent event) {

    return events.stream()
        .anyMatch(each ->
            (
                event.getStartAt().isBefore(each.getEndAt()) &&
                event.getStartAt().isAfter(each.getStartAt())
            ) ||
            (
                event.getEndAt().isAfter(each.getStartAt()) &&
                event.getEndAt().isBefore(each.getEndAt())
            )
        );
  }
}
