package com.adancau.trainings.collaberra;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CsvFileProcessor {

    private CsvFileReader csvFileReader;

    public CsvFileProcessor() {
        csvFileReader = new CsvFileReader();
    }

    public void processFile(String filePath) {
        File file = csvFileReader.readFile(filePath);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        System.out.println(scanner.next());
    }
}
