// full points
import java.util.*;
import java.nio.*;
import java.io.*;

import java.nio.file.*;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.stream.Stream;



public class Flag {




    public static void main(String[] args) {

        ArrayList<String> allData = new ArrayList<String>();

        Path inputFile =  Paths.get("2021/11/27/Question 2/flag.dat");

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


        // System.out.println("MINUS START " +minusStart);

        // in each line, for each char, check if char = " ". if char = " '", then note the index and make a substring

        for (int b = 0; b < minusStart.size(); b++) {

            int indexOfSpace = minusStart.get(b).indexOf(" ");

            String firstHalf = minusStart.get(b).substring(0, indexOfSpace);

            // need to get the number of characters
            int lineLength = minusStart.get(b).length();

            indexOfSpace ++;
    
            String secondHalf = minusStart.get(b).substring(indexOfSpace, lineLength);
            
            // sends the width and the height to the method
            // flag1.makeSquare(Integer.valueOf(firstHalf), Integer.valueOf(secondHalf));

            int height = Integer.valueOf(firstHalf);
            int width = Integer.valueOf(secondHalf);

            for (int a = 0; a < width; a++) {
                System.out.print("#");
            }
            System.out.println("");
    
            
            // MIDDLE OF THE SHAPE
    
            int middleHeight = height - 2;
            int middleWidth = width -2;
            
            for (int i = 0; i < (middleHeight); i++) {
    
    
                System.out.print("#");
                
                for (int x = 0; x < middleWidth; x++) {
                    System.out.print(" ");
                }
    
                System.out.println("#");
    
    
            }
    
            // bottom border
            for (int a = 0; a < width; a++) {
                System.out.print("#");
            }



            System.out.println("");
            System.out.println("----------");
            System.out.println("");  
        }


       
    

    // ADD FUNCTION

    
    






        







    }


}