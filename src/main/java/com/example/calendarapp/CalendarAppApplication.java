package com.example.calendarapp;

import com.example.calendarapp.event.*;
import com.example.calendarapp.event.update.UpdateMeeting;
import com.example.calendarapp.reader.EventCsvReader;
import com.example.calendarapp.reader.RawCsvReader;
import com.opencsv.exceptions.CsvException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

//@SpringBootApplication
public class CalendarAppApplication {

  public static void main(String[] args) throws IOException, CsvException {

//    SpringApplication.run(CalendarAppApplication.class, args);

    Schedule schedule = new Schedule();

    EventCsvReader csvReader = new EventCsvReader(new RawCsvReader());
    String meetingCsvPath = "/data/meeting.csv";
    String noDisturbanceCsvPath = "/data/no_disturbance.csv";
    String outOfOfficeCsvPath = "/data/out_of_office.csv";
    String toDoCsvPath = "/data/to_do.csv";

    List<Meeting> meetings = csvReader.readMeetings(meetingCsvPath);
    meetings.forEach(schedule::add);

    List<NoDisturbance> noDisturbances =
        csvReader.readNoDisturbance(noDisturbanceCsvPath);
    noDisturbances.forEach(schedule::add);

    List<OutOfOffice> outOfOffices =
        csvReader.readOutOfOffice(outOfOfficeCsvPath);
    outOfOffices.forEach(schedule::add);

    List<Todo> todos = csvReader.readTodo(toDoCsvPath);
    todos.forEach(schedule::add);

    schedule.pringAll();

    /*
    schedule.pringAll();

    // update - before
    Meeting meeting = meetings.get(0);
    System.out.println("수정 전..");
    meeting.print();

    // update
    System.out.println("수정 진행..");
    meeting.validateAndUpdate(
        new UpdateMeeting(
            "new title",
            ZonedDateTime.now(),
            ZonedDateTime.now().plusHours(1),
            null,
            "Room A",
            "new agenda"
        )
    );

    System.out.println("수정 결과..");
    meeting.print();

    // 삭제
    meeting.delete(true);
    System.out.println("삭제 후 수정 시도..");
    meeting.validateAndUpdate(
        new UpdateMeeting(
            "new title 2",
            ZonedDateTime.now(),
            ZonedDateTime.now().plusHours(1),
            null,
            "Room A2",
            "new agenda2"
        )
    );

     */
  }

}
