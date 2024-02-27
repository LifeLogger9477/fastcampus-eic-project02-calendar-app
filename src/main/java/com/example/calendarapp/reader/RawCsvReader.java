package com.example.calendarapp.reader;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * author : ms.Lee
 * date   : 2024-02-27
 */
// EventCsvReader -> readAll을 Mocking 처리하기 위해 만든 class
public class RawCsvReader {

  public List<String[]> readAll(String path) throws IOException, CsvException {

    InputStream in = getClass().getResourceAsStream(path);
    InputStreamReader reader =
        new InputStreamReader(in, StandardCharsets.UTF_8);

    CSVReader csvReader = new CSVReader(reader);
    return csvReader.readAll();
  }
}
