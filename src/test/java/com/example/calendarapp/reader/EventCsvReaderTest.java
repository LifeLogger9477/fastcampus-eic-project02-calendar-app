package com.example.calendarapp.reader;

import com.example.calendarapp.event.Meeting;
import com.opencsv.exceptions.CsvException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

/**
 * author : ms.Lee
 * date   : 2024-02-27
 */
@ExtendWith(MockitoExtension.class)
class EventCsvReaderTest {

  private final static String YYYY_MM_DD_HH_MM_DD = "yyyy-MM-dd HH:mm:ss";

  // RawCsvReader -> Mocking 처리
  @Mock
  private RawCsvReader rawCsvReader;

  @InjectMocks
  private EventCsvReader sut;

  @Test
  public void reader() throws IOException, CsvException {

    // given
    String path = "";
    // EventCsvReader sut = new EventCsvReader(rawCsvReader);
    // -> @InjectMocks 할 때 넣어줌

    // Mock data 생성
    List<String[]> mockData = new ArrayList<>();
    // header 에 대해서 skip 하기 떄문에 임의의 값을 사용
    mockData.add(new String[8]);

    int sizeMock = 5;
    for (int i = 0; i < sizeMock; i++) {

      mockData.add(generateMock(i + 1));
    }

    when(rawCsvReader.readAll(path))
        .thenReturn(mockData);

    // when
    List<Meeting> meetings = sut.readMeetings(path);


    // then
    assertEquals(sizeMock, meetings.size());
    assertEquals("title1", meetings.get(0).getTitle());
  }

  private String[] generateMock(int id) {

    String[] mock = new String[8];

    mock[0] = String.valueOf(id);
    mock[1] = "MEETING" + id;
    mock[2] = "title" + id;
    mock[3] = "A,B,C";
    mock[4] = "A1" + id;
    mock[5] = "agenda test" + id;
    mock[6] = of(ZonedDateTime.now().plusHours(id));
    mock[7] = of(ZonedDateTime.now().plusHours(id + 1));

    return mock;
  }

  private static String of(ZonedDateTime dateTime) {

    return dateTime.format(DateTimeFormatter.ofPattern(YYYY_MM_DD_HH_MM_DD));
  }
}