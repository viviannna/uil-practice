// FULL SCORE; 60 PTS
import java.util.*;
import java.nio.*;
import java.io.*;

import java.nio.file.*;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.stream.Stream;

public class Budget {

    public static void main(String[] args) {
        ArrayList<String> allData = new ArrayList<String>();

        Path inputFile =  Paths.get("2021/11/27/Question 5/budget.dat");

        try (Stream <String> stream = Files.lines(inputFile)) {
            stream.forEach(line -> {

                allData.add(line);

            });

        }

        catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<String> minusStart = new ArrayList<String>();


        // get rid of the starting one
        for (int i = 1; i < allData.size(); i++) {
            minusStart.add(allData.get(i));
        }

        // for each line, 
        for (int b = 0; b < minusStart.size(); b++) {

            int indexOfSpace = minusStart.get(b).indexOf(" ");
            String firstHalf = minusStart.get(b).substring(0, indexOfSpace);

            // need to get the number of characters
            int lineLength = minusStart.get(b).length();
            indexOfSpace ++;
            String secondHalf = minusStart.get(b).substring(indexOfSpace, lineLength);


            double totalIncome = Double.valueOf(firstHalf);
            double defecit = Double.valueOf(secondHalf);


            double tax = ((defecit/totalIncome) * 100);
            System.out.println(Math.round(tax+0.5) + "%");



        }

    }
}

