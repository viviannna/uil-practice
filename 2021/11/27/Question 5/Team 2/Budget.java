import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Budget {
    public static void main (String[] args) throws FileNotFoundException {

        ArrayList<String> fileArray = new ArrayList<String>(); 
        Scanner inputFile = new Scanner(new File("budget.dat"));

        while (inputFile.hasNextLine()) {
            fileArray.add(inputFile.nextLine());
        }

        int numOfCases = Integer.parseInt(fileArray.get(0));
        fileArray.remove(0);

        for (int i=0; i<numOfCases; i++) {
            String entry = fileArray.get(i);

            String[] splitEntry = entry.split(" ");
            
            double income = Double.parseDouble(splitEntry[0]);
            double debt = Double.parseDouble(splitEntry[1]);

            double percent = Math.ceil(income/debt);
            System.out.println(percent + "%");
        }
    }
}
