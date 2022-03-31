import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class Bryan {
    public static void main(String[] args) throws Exception {

        // read the file
        File file = new File("bryan.dat");
        Scanner sc = new Scanner(file);
        ArrayList<String> allData = new ArrayList<String>();


        while (sc.hasNextLine()) {
            allData.add(sc.nextLine());
        }

        int numWeeks = Integer.parseInt(allData.get(0)); 
        allData.remove(0);

        int weekStartIndex = 0;
        int numTasks = 0;

        // for each week 
        for (int weekCount = 1; weekCount <= numWeeks; weekCount++) {
            
            int moneyTotal = 0;
            numTasks = Integer.parseInt(allData.get(weekStartIndex));

            // for each task
            for (int taskCount = (weekStartIndex + 1); taskCount <= (weekStartIndex + numTasks); taskCount ++) {

                // get rid of the name 
                String word = allData.get(taskCount);
                word = word.substring(word.indexOf(" "));
                

                int number = 0;

                // if negative
                int indexOfNeg = word.indexOf("-"); 
                
                if (indexOfNeg < 0) {

                    word = word.substring(1);
                    number = Integer.parseInt(word);
                }
                
                else {

                    word = word.substring(indexOfNeg);
                    number = Integer.parseInt(word);
                
                }

                moneyTotal += number;               

            }

            String result = "";

            if (moneyTotal == 0) {
                result = "Phew, broke even!";
            }

            else if (moneyTotal < 0) {
                result = "Oh no! Bryan had to borrow $"+(moneyTotal*-1);
            }

            else {
                result = "Wow, Bryan saved $"+moneyTotal;
            }

            System.out.println("Case #"+weekCount+": "+result);

            // brings you to the next week 
            weekStartIndex = weekStartIndex + 1 + numTasks;

        }

    









    }
}