import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Facundo {
    public static void main(String args[]) throws FileNotFoundException{
        ArrayList<String> fileArray = new ArrayList<String>(); 
        Scanner inputFile = new Scanner(new File("facundo.dat"));

        while (inputFile.hasNextLine()) {
            fileArray.add(inputFile.nextLine());
        }
        
        fileArray.remove(0);

        for (String line : fileArray) {
            String[] splitLine = line.split(" ");
            String deck = splitLine[0];
            int timesShuffled = Integer.parseInt(splitLine[1]);

            boolean isEven = deck.length() % 2 == 0;

            for (int i = 0; i < timesShuffled; i++) {
                String upperDeck = "";
                String lowerDeck = "";
                if (isEven) {
                    upperDeck = deck.substring(0, deck.length()/2);
                    lowerDeck = deck.substring(deck.length()/2, deck.length());
                } else {
                    upperDeck = deck.substring(0, deck.length()/2 + 1);
                    lowerDeck = deck.substring(deck.length()/2 + 1, deck.length());
                }
                
                String newDeck = "";

                if (isEven) {
                    for(int j = upperDeck.length()-1; j>=0; j--) {
                        newDeck = upperDeck.charAt(j) + newDeck;
                        newDeck = lowerDeck.charAt(j) + newDeck;
                    }
                } else {
                    for(int j = lowerDeck.length()-1; j>=0; j--) {
                        newDeck = upperDeck.charAt(j+1) + newDeck;
                        newDeck = lowerDeck.charAt(j) + newDeck;
                    }
                    newDeck = upperDeck.charAt(0) + newDeck;
                }

                deck = newDeck;
            }
            System.out.println(deck);
        }
    }
}