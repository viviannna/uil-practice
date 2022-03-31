import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Michaela {
    public static void main(String args[]) throws FileNotFoundException{
        ArrayList<String> fileArray = new ArrayList<String>(); 
        Scanner inputFile = new Scanner(new File("michaela.dat"));

        while (inputFile.hasNextLine()) {
            fileArray.add(inputFile.nextLine());
        }
        
        fileArray.remove(0);

        for (int test = 0; test<fileArray.size(); test++) {
            String line = fileArray.get(test);
            System.out.print("Message #"+ (test+1) + ": ");
            String liner = line.toUpperCase();
            for(int i=0; i<line.length(); i++){
                char letter = liner.charAt(i);
                String stream = Integer.toString(letter, 2);
                String result = "";
                for(int j = 0; j<=stream.length(); j++){
                    if (j == stream.length()) {
                        result += " ";
                    }
                    else if(Integer.parseInt(Character.toString(stream.charAt(j))) == 0) {
                        result += ".";
                    } else {
                        result += "-";
                    }
                }
                System.out.print(result);   
            }
            System.out.println();
        }
    }
}