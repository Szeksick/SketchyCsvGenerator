package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static com.company.GeneratorUtils.*;

public class JobOffer {
    private File output = new File("C:\\Projects\\Java\\NSPD\\CSVGenerator\\jobOffer.csv");

    public void generateCsv() {
        new CsvGenerator().generate(initData(), output);
    }

    private List<String[]> initData() {
        List<String[]> dataLines = new ArrayList<>();
        Set<String> cities = getCityProvinceMap().keySet();
        List<String> categories = getCategories();
        dataLines.add(new String[]{"id", "idCategory", "idCity", "salary", "contractType", "companyName", "publicationDate", "endDate"});
        for (int i = 0; i <= 10000; i++) {
            String[] line = {
                    String.valueOf(i), getRandomNumberString(0, categories.size()), getRandomNumberString(0, cities.size()),
                    getRandomNumberString(1700, 10000), getRandomContractType(), getRandomCompanyName(),
                    getRandomPastDate(), getRandomFutureDate()};
            dataLines.add(line);
            System.out.println(line.toString());
        }
        return dataLines;
    }

}
