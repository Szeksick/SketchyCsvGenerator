package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.company.GeneratorUtils.*;

public class Category {
    private File output = new File("C:\\Projects\\Java\\NSPD\\CSVGenerator\\category.csv");

    public void generateCsv(){
        new CsvGenerator().generate(initData(), output);
    }

    private List<String[]> initData() {
        List<String[]> dataLines = new ArrayList<>();
        List<String> categories = getCategories();
        dataLines.add(new String[]{"idCategory", "name"});
        for (int i = 0; i < categories.size(); i++){
            String[] line = {
                    String.valueOf(i), categories.get(i)};
            dataLines.add(line);
            System.out.println(line.toString());
        }
        return dataLines;
    }
}
