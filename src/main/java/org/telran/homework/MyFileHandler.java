package org.telran.homework;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;

public class MyFileHandler {
    public File createDirectory(String directoryPath) {
        File file = new File(directoryPath);
        if (!file.exists()) {
            file.mkdir();
            return file;
        }
        System.out.println("Such directory already exist");
        return file;
    }

    public void deleteDirectory(String directoryPath) {
        File dir = new File(directoryPath);
        File[] currList;
        Stack<File> stack = new Stack<>();
        stack.push(dir);
        while (!stack.isEmpty()) {
            if (stack.lastElement().isDirectory()) {
                currList = stack.lastElement().listFiles();
                if (currList.length > 0) {
                    for (File curr : currList) {
                        stack.push(curr);
                    }
                } else {
                    stack.pop().delete();
                }
            } else {
                stack.pop().delete();
            }
        }
    }

    public void generateFile(String directoryPath, String filename, String text) {
        File file = new File(directoryPath + "\\" + filename);
        try {
            try (FileWriter fileWriter = new FileWriter(file)) {
                fileWriter.write(text);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
