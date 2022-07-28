package com.adancau.trainings.collaberra;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CsvFileProcessor {

    private static final String COMMA = ",";
    private static final int USER_ID_INDEX = 0;
    private static final int ORDER_COST_INDEX = 1;

    public CsvFileProcessor() {
    }

    public void processFile(String filePath) {

        try (Scanner scanner = new Scanner(new File(filePath))) {
            Map<Integer, Integer> resultMap = new HashMap<>();


            scanner.nextLine();
            while (scanner.hasNext()) {
                String lineContent = scanner.nextLine();
                processLineContent(resultMap, lineContent.split(COMMA));
            }

            for (Map.Entry<Integer, Integer> entry : resultMap.entrySet()) {
                System.out.println(entry.getKey() + " = " + entry.getValue());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    private void processLineContent(Map<Integer, Integer> map, String[] content) {
        Integer userId;
        Integer costOfOrder;
        try {
            userId = Integer.parseInt(content[USER_ID_INDEX]);
            costOfOrder = Integer.parseInt(content[ORDER_COST_INDEX]);
            map.put(userId, map.containsKey(userId) ? map.get(userId) + costOfOrder : costOfOrder);
        } catch (NumberFormatException ex) {

        }
    }
}
