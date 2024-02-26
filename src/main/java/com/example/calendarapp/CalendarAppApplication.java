package com.example.calendarapp;

import com.example.calendarapp.event.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

//@SpringBootApplication
public class CalendarAppApplication {

  public static void main(String[] args) {

//    SpringApplication.run(CalendarAppApplication.class, args);

    // 4개의 타입에 대한
    /*
    List<AbstractEvent> list = new ArrayList<>();
    //--> schedule class 로 변경
    */
    Schedule schedule = new Schedule();

    HashSet<String> participants = new HashSet<>();
    participants.add("danny.kim");

    Meeting meeting1 = new Meeting(
        1,
        "meeting1",
        ZonedDateTime.now(),
        ZonedDateTime.now().plusHours(1),
        participants,
        "meetRoomA",
        "스터디"
    );
    // list.add(meeting1);
    schedule.add(meeting1);

    Todo todo1 = new Todo(
        2,
        "todo1",
        ZonedDateTime.now(),
        ZonedDateTime.now().plusHours(2),
        "할 일 적기"
    );
    // list.add(todo1);
    schedule.add(todo1);

    Todo todo2 = new Todo(
        3,
        "todo2",
        ZonedDateTime.now().plusHours(5),
        ZonedDateTime.now().plusHours(4),
        "할 일 적기"
    );
    schedule.add(todo2);

    // list.forEach(Event::print);
    schedule.pringAll();

    // 미팅만 뽑아서 보고 싶을 때
    /*
    list.stream()
        .filter(each -> each instanceof Meeting)
        .collect(Collectors.toList());

        //--> 위의 방법보다 별도의 메소드 만들기 - 아래 방법
    */

    /*
    list.stream()
        .filter(each -> each.support(EventType.MEETING))
        .forEach(Event::print);
    //--> schedule class 의 printBy로 변경
     */

    schedule.printBy(EventType.MEETING);
  }

}
