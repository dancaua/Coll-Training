package utils;

import java.io.File;

import static java.util.Objects.isNull;

public class DirectoryScanner {

    public void scan(String folderPath) {
        if (isNull(folderPath) || folderPath.isEmpty()) {
            return;
        }

        File directory = new File(folderPath);

        if (isNull(directory.listFiles())) {
            return;
        }

        for (File file : directory.listFiles()) {
            if (file.isDirectory()) {
                System.out.println(file.getName() + " is a directory");
            } else {
                System.out.println(file.getName() + " is a " + getFileExtension(file));
            }
        }
    }


    private String getFileExtension(File file) {
        String name = file.getName();
        return name.substring(name.lastIndexOf("."));
    }
}
