import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.*;

public class Maximo {

    /* creates a method here (NOT A CLASS). no constructors needed, you don't have to make an 
    object everytime you want to use it. just use cleanString(); */

    public static List cleanString(String givenString) {
        
        // get rid of the "A =" and the "{}"
        givenString = givenString.substring(3, (givenString.length() - 1));

        // this makes sure that it doesn't split double digit numbers
        String str[] = givenString.split(",");
        List<String> setList = new ArrayList<String>();
        setList = Arrays.asList(str);

        // convert all the string values into ints >> makes it easier later when we're comparing lists

        ArrayList<Integer> integerList = new ArrayList<Integer>();

        for (int eachNum = 0; eachNum < setList.size(); eachNum ++) {
            integerList.add(Integer.parseInt(setList.get(eachNum)));
        }

        Collections.sort(integerList); // necessary since we're using .equals()
        
        return integerList; 

    }

    public static void main(String[] args) throws Exception{

        // READ FILE
        File file = new File("maximo.dat");
        Scanner sc = new Scanner(file);
        ArrayList<String> fileLines = new ArrayList<String>();

        while (sc.hasNextLine()) {
            fileLines.add(sc.nextLine());
        }

        // BREAK INTO EACH SECTION -- two sets to compare
        for (int lineNum = 1; lineNum < fileLines.size(); lineNum += 2) {

            List<Integer> setA = new ArrayList<Integer>();
            List<Integer> setB = new ArrayList<Integer>();

            setA = cleanString(fileLines.get(lineNum));
            setB = cleanString(fileLines.get(lineNum + 1));


            ArrayList<Integer> intersection = new ArrayList<Integer>(); 

            // FOR EACH NUMBER IN THE STRING

            for (int aIndex = 0; aIndex < setA.size(); aIndex ++) {

                for (int bIndex = 0; bIndex < setB.size(); bIndex ++) {

                    if(setA.get(aIndex) == (setB.get(bIndex))) {
                        intersection.add(setA.get(aIndex));
                    }
                }
               
            } // end of check for intersections


            // CHECK FOR SUBSETS
            if ((intersection.equals(setA)) && (intersection.equals(setB))) {
                System.out.println("Set A is equal to Set B");
            }
            else if (intersection.equals(setA)) {
                System.out.println("A is a subset of B");
            }

            else if (intersection.equals(setB)) {
                System.out.println("B is a subset of A");
            }

            else {
                System.out.println("Neither is a subset of the other. Their intersection is "+intersection);
            }

            



           






        }
        

    



    }
}