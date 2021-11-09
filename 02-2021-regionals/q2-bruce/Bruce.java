import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class Bruce {
    public static void main (String[] args) throws Exception {

        File file = new File("bruce.dat");
        Scanner sc = new Scanner(file);

        ArrayList<String> allData = new ArrayList<String>();

        while (sc.hasNextLine()) {
            allData.add(sc.nextLine());
        }

        for (int lineNum = 1; lineNum < allData.size(); lineNum++) {
            // square root the number and multiply by four
            Double newVal = Math.sqrt(Double.parseDouble(allData.get(lineNum))) * 4;

            // round it to four digits
            System.out.printf("%.4f %n", newVal);
            
        }

        


    }
}