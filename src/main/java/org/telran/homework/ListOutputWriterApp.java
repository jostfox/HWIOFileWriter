package org.telran.homework;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListOutputWriterApp {

    public static void main(String[] args) throws IOException {


        String testString = "This is my first experience when I myself work with IO API";


        List<String> myList = new ArrayList<>();
        try (ListOutputWriter listOutputWriter = new ListOutputWriter(myList)) {
            try {
                listOutputWriter.write(testString.toCharArray());
            } catch (IOException e) {
                e.printStackTrace();
            }

            listOutputWriter.getStringList().forEach(System.out::println);
        }
    }
}


