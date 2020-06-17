package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.company.GeneratorUtils.*;

public class Province {
    private File output = new File("C:\\Projects\\Java\\NSPD\\CSVGenerator\\province.csv");

    public void generateCsv() {
        new CsvGenerator().generate(initData(), output);
    }

    private List<String[]> initData() {
        List<String[]> dataLines = new ArrayList<>();
        Map<String, String> cityProvinceMap = getCityProvinceMap();
        List<String> provinces = new ArrayList<>(cityProvinceMap.values());
        dataLines.add(new String[]{"idProvince", "name"});
        for (int i = 0; i < provinces.size(); i++){
            String[] line = {
                    String.valueOf(i), provinces.get(i)};
            dataLines.add(line);
            System.out.println(line.toString());
        }
        return dataLines;
    }

}
