import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Flag {
    public static void main (String[] args) throws FileNotFoundException {

        ArrayList<String> fileArray = new ArrayList<String>(); 
        Scanner inputFile = new Scanner(new File("flag.dat"));

        while (inputFile.hasNextLine()) {
            fileArray.add(inputFile.nextLine());
        }

        int numOfCases = Integer.parseInt(fileArray.get(0));
        fileArray.remove(0);

        for (int i=0; i<numOfCases; i++) {
            String entry = fileArray.get(i);
            String[] splitEntry = entry.split(" ");

            int height = Integer.parseInt(splitEntry[0]);
            int width = Integer.parseInt(splitEntry[1]);

            int spaces = width - 2;

            for (int h=0; h<height; h++) {
                if (h==0 || h==(height-1)) {
                    for (int x=0; x<width; x++) {
                        System.out.print("#");
                    }
                    System.out.println("");
                } else {
                    System.out.print("#");
                    int tempSpaces = spaces;
                    while (tempSpaces > 0) {
                        System.out.print(" ");
                        tempSpaces--;
                    }
                    System.out.print("#");
                    System.out.println("");
                }
            }
            System.out.println("----------");
        }
    }
}
