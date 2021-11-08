import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Registry {

    private static double[] myArray;
    private static double[] tempArray;

    private static void mergeSort(double arr[]) {
        myArray = arr;
        int length = arr.length;
        tempArray = new double[length];
        setUpMerge(0, length-1);
    }

    private static void setUpMerge(int lower, int higher) {
        if (lower < higher) {
            int middle = lower + (higher - lower) / 2;
            setUpMerge(lower, middle);
            setUpMerge(middle + 1, higher);
            doTheMerge(lower, middle, higher);
        }
    }

    private static void doTheMerge(int lower, int middle, int higher) {
        for (int i=lower; i<=higher; i++) {
            tempArray[i] = myArray[i];
        }
        int i = lower;
        int j = middle + 1;
        int k = lower;
        while (i<=middle && j<=higher) {
            if(tempArray[i] <= tempArray[j]) {
                myArray[k] = tempArray[i];
                i++;
            } else {
                myArray[k] = tempArray[j];
                j++;
            }
            k++;
        }
        while (i<=middle) {
            myArray[k] = tempArray[i];
            k++;
            i++;
        }
    }

    public static void main (String[] args) throws FileNotFoundException {

        ArrayList<String> fileArray = new ArrayList<String>(); 
        Scanner inputFile = new Scanner(new File("registry.dat"));

        while (inputFile.hasNextLine()) {
            fileArray.add(inputFile.nextLine());
        }

        int numOfCases = Integer.parseInt(fileArray.get(0));
        fileArray.remove(0);

        int ageSum = 0;
        double[] incomeArray = new double[numOfCases];

        for (int i=0; i<numOfCases; i++) {
            String thisCase = fileArray.get(i);
            String[] splitCase = thisCase.split(", ");

            String name = splitCase[0];
            int age = Integer.parseInt(splitCase[1]);
            double income = Double.parseDouble(splitCase[2].substring(0, splitCase[2].length()));

            ageSum += age;
            incomeArray[i] = income;
        }
        
        mergeSort(incomeArray);

        double medianIncome = incomeArray[incomeArray.length/2];
        System.out.println(medianIncome);
        double ageMean = Math.round((ageSum/numOfCases)*100)/100;

        System.out.println("Georgelandia's Mean Age: " + (ageMean));
        System.out.println("Georgelandia's Median Annual Income: $" + medianIncome);
    }
}
