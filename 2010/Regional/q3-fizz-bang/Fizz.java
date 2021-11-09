import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.BufferedReader;


public class Fizz {
    public static void main (String[] args) throws Exception{ // throws Exception is needed when using scanner to read files
        
        ArrayList<String> allData = new ArrayList<String>();

        // READ THE FILE
        File file = new File("fizz.dat");
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            allData.add(sc.nextLine()); // while there is a next line, add the next line to the array
        }

        // int numDataSets = Integer.valueOf(allData.get(0));

        // FOR EACH DATA SET
        // set at one to ignore the value that tell us how many data sets
        for (int a = 1; a < allData.size(); a++) {
            
            System.out.println("Data Set "+ a);
            // GET THE START AND END NUMBERS
        
            int indexOfSpace = allData.get(a).indexOf(" ");
            String firstHalf = allData.get(a).substring(0, indexOfSpace); 

            indexOfSpace++;
            int lineLength = allData.get(a).length();

            String secondHalf = allData.get(a).substring(indexOfSpace, lineLength);


            int startNum = Integer.parseInt(firstHalf);
            int endNum = Integer.parseInt(secondHalf);

            // START COUNTING
            
            // for each number in between start and end
            for (int b = startNum; b <= endNum; b++) { 
                if (b % 3 == 0) { // multiple of three
                    if (b % 5 == 0) { // and not a multiple of five
                        System.out.println("FizzBang");
                    }
                    else {
                        System.out.println("Fizz");
                    }
                }

                else if (b % 5 == 0) {
                    System.out.println("Bang");
                }

                else {
                    System.out.println(b);
                }

            }

        }




        // count from start to end -- break into a new array

        // for each numebr in between start and end, see if they are multiples and if so replace them

        // if(num % 3 == 0) { // multiple of 3
        //     if(num % 5 != 0) { // and not a multiple of 5
        //         // replace the number with fizz
        //     }
        //     else {
        //         // replace the number with fizzbang
        //     }
        // } 

        // else if (num % 5 == 0) { // multiple of 5
        //     // replace the number with bang
        // }
        
    }
}