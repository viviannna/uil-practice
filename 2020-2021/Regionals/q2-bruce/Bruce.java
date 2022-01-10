// import necessary classes 

import java.util.ArrayList;     /* create lists */
import java.util.Scanner;       /* get input either from user or from file */
import java.io.File;            /* read files */




public class Bruce {
    public static void main(String args[]) throws Exception {



        // READ THE FILE 

        //- set up to read the file
        File file = new File("bruce.dat");                      // create a new file
        Scanner sc = new Scanner(file);                         // create a new object of the scanner class that reads data from the file 
        ArrayList<String> allData = new ArrayList<String>(); 

        //- read the file & add data to a list

        while(sc.hasNextLine()) {
            allData.add(sc.nextLine());                         // add each line in the file to the list
        }


        // DO THE CALCULATIONS

        //- ignore the first number, for each number
        for(int lineNum = 1; lineNum < allData.size(); lineNum ++ ) {
            
            //-- convert the number from a string to a double
            Double currentNum = Double.parseDouble(allData.get(lineNum));

            currentNum = Math.pow(currentNum, 0.5);
            currentNum *= 4;

            // need to round to four decimal places
            System.out.printf("%.4f %n", currentNum);

    }
        }

            
}