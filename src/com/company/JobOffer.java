package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static com.company.GeneratorUtils.*;

public class JobOffer {
    private File output = new File("C:\\Projects\\Java\\NSPD\\CSVGenerator\\jobOffer.csv");

    public void generateCsv(){
        new CsvGenerator().generate(initData(), output);
    }

    private List<String[]> initData(){
        List<String[]> dataLines = new ArrayList<>();
        dataLines.add(new String[]{"id", "idCategory", "idCity", "salary", "contractType", "companyName", "publicationDate", "endDate"});
        for (int i = 0; i <= 10000; i++) {
            String[] line = {
                    String.valueOf(i), getRandomNumberString(0, 10), getRandomNumberString(0, 100),
                    getRandomNumberString(1700, 10000), getRandomContractType(), getRandomCompanyName(),
                    getRandomPastDate(), getRandomFutureDate()};
            dataLines.add(line);
            System.out.println(line.toString());
        }
        return dataLines;
    }

}
