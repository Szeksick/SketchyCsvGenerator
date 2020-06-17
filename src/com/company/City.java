package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.company.GeneratorUtils.*;

public class City {
    private File output = new File("C:\\Projects\\Java\\NSPD\\CSVGenerator\\city.csv");

    public void generateCsv(){
        new CsvGenerator().generate(initData(), output);
    }

    private List<String[]> initData() {
        List<String[]> dataLines = new ArrayList<>();
        Map<String, String> cityProvinceMap = getCityProvinceMap();
        List<String> cities = new ArrayList<>(cityProvinceMap.keySet());
        List<String> provinces = new ArrayList<>(cityProvinceMap.values());
        dataLines.add(new String[]{"idCity", "name", "idProvince"});
        for (int i = 0; i < cities.size(); i++){
            String[] line = {
                    String.valueOf(i), cities.get(i), String.valueOf(i)};
            dataLines.add(line);
            System.out.println(line.toString());
        }
        return dataLines;
    }
}
