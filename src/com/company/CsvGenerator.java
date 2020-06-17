package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.company.GeneratorUtils.*;

public class CsvGenerator {
    public void generate(List<String[]> dataLines, File output) {
        try (
                PrintWriter pw = new PrintWriter(output)) {
            dataLines.stream()
                    .map(this::convertToCSV)
                    .forEach(pw::println);
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public String convertToCSV(String[] data) {
        return Stream.of(data)
                .map(GeneratorUtils::escapeSpecialCharacters)
                .collect(Collectors.joining(","));
    }
}
