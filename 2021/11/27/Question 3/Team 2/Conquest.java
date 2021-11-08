import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Conquest {
    public static void main (String[] args) throws FileNotFoundException {

        ArrayList<String> fileArray = new ArrayList<String>(); 
        Scanner inputFile = new Scanner(new File("conquest.dat"));

        while (inputFile.hasNextLine()) {
            fileArray.add(inputFile.nextLine());
        }

        int numOfCases = Integer.parseInt(fileArray.get(0));
        fileArray.remove(0);

        for (int i=0; i<numOfCases; i++) {
            String dimensions = fileArray.get(0);
            String[] splitDimensions = dimensions.split(" ");
            fileArray.remove(0);

            int rows = Integer.parseInt(splitDimensions[0]);
            int columns = Integer.parseInt(splitDimensions[1]);

            String[][] map = new String[rows][columns];

            int territories = 0;

            for (int r=0; r<rows; r++) {
                String completeRow = fileArray.get(0);
                for (int c=0; c<columns; c++) {
                    Character checkTerritory = new Character(completeRow.charAt(c));
                    map[r][c] = checkTerritory.toString();
                    if (map[r][c].equals("x")) {
                        territories++;
                    }
                }
                fileArray.remove(0);
            }
            System.out.println("George has conquered " + territories + " unit(s) of territory");
        }
    }
}