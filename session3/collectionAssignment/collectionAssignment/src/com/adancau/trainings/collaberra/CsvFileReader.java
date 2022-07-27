package com.adancau.trainings.collaberra;

import java.io.File;

import static java.util.Objects.isNull;

public class CsvFileReader {

    public File readFile(String filePath) {
        if (isNull(filePath) || filePath.isEmpty()) {
            return null;
        }
        return new File(filePath);
    }
}
