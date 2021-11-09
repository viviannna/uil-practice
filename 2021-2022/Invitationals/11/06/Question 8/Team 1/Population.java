// MATH ERROR; 0 PTS
import java.util.*;
import java.nio.*;
import java.io.*;

import java.nio.file.*;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.stream.Stream;


public class Population {
    public static void main (String[] args) {

        ArrayList<String> allData = new ArrayList<String>();

        Path inputFile =  Paths.get("2021/11/27/Question 8/population.dat");

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

        for (int b = 0; b < minusStart.size(); b++) {

            int indexOfSpace = minusStart.get(b).indexOf(" ");

            String firstHalf = minusStart.get(b).substring(0, indexOfSpace);

            // need to get the number of characters
            int lineLength = minusStart.get(b).length();

            indexOfSpace ++;
    
            String secondHalf = minusStart.get(b).substring(indexOfSpace, lineLength);


            int numYears = Integer.valueOf(secondHalf);
            int ogPop = Integer.valueOf(firstHalf);



            double populationAfter = (ogPop)*(Math.pow(1.05, numYears));

            double roundedPop = Math.round(populationAfter+0.5);

            System.out.println("Population after "+numYears+" years: "+ (int)roundedPop);

        }

        

    }
}
