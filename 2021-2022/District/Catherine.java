import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Catherine {
    public static void main(String args[]) throws Exception{
        ArrayList<String> allData = new ArrayList<String>(); 
        File file = new File("catherine.dat");
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            allData.add(sc.nextLine());
        }

        for (int line = 1; line < allData.size(); line++ ) {

            String[] entry = allData.get(line).split(" ");
            String target = entry[0];
            String guess = entry[1];

            String evaluated = "";

            // for each character in the guess word
            for (int letterIndx = 0; letterIndx < guess.length(); letterIndx++) {

                String guessChar = Character.toString(guess.charAt(letterIndx));
                String targetChar = Character.toString(target.charAt(letterIndx));

                // if the character is an exact match of the character in the target word

                if (guessChar.equals(targetChar)) {
                    // at that exact index, replace it with a CAPITAL version
                    evaluated += guessChar.toUpperCase();
                }

                // if the character is a match SOMEWHERE
                else if(target.indexOf(guessChar) >= 0) {
                    evaluated += guessChar;
                }

                // else if it's not in word at all 

                else {
                    evaluated += "*";
                }



                
            } // end of for each character


            System.out.println(evaluated);



        }





    } // end of main

} // end of all code
        