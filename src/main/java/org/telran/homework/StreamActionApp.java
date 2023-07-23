package org.telran.homework;

import java.io.File;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamActionApp {

    public static void main(String[] args) {

        //Task 2.2.1

        printTask("2.2.1");
        String message = "This is my first experience when I myself work with IO API";
        String[] messages = message.split(" ");
        System.out.println(Arrays.toString(messages));

        Map<String, String> filenames = Arrays.stream(messages)
                .collect(Collectors.toMap(s -> s + ".txt", s -> s));

        filenames.forEach((key, value) -> System.out.printf("Key - %s, value - %s\n", key, value));

        //Task 2.2.2

        printTask("2.2.2");
        MyFileHandler myFileHandler = new MyFileHandler();
        String directoryPath = "C:\\Users\\Oleg Rulyov\\Desktop\\HWJavaFile";
        myFileHandler.createDirectory(directoryPath);     // Create empty folder

        filenames.forEach((k, v) -> myFileHandler.generateFile(directoryPath, k, v));

        System.out.println("The folder was created. -- " + (new File(directoryPath)).exists());
    }

    static void printTask(String number) {
        System.out.printf("\nTask %s", number);
        System.out.println("\n==================");
    }
}
