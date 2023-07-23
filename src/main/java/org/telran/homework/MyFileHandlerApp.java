package org.telran.homework;

import java.util.Arrays;
import java.util.List;

public class MyFileHandlerApp {

    public static void main(String[] args) {

        String intitialDirectory = "D:\\Telran\\Java\\Pro\\Homework\\14 HWInputOutput";
        List<String> folderList = Arrays.asList("\\Test", "\\TestTwo", "\\TestThree");

        MyFileHandler myFileHandler = new MyFileHandler();

        //Создание дерева для работы с ним "...\Test\TestTwo\TestThree

        final String[] currentDirectory = {intitialDirectory};
        folderList.forEach(s -> {
            myFileHandler.createDirectory(currentDirectory[0] + s);
            currentDirectory[0] += s;
        });

        String tempFolder = intitialDirectory + "\\Test";

        myFileHandler.deleteDirectory(tempFolder);

        myFileHandler.createDirectory(tempFolder);

        //Task 2.1
        String textTofile = "Test! " + "Test! " + "Test! ";
        myFileHandler.generateFile(tempFolder, "example.txt", textTofile);
    }
}
