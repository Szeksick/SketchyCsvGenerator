package com.company;

import java.io.File;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        new JobOffer().generateCsv();
        new City().generateCsv();
        new Category().generateCsv();
        new Province().generateCsv();
    }
}
