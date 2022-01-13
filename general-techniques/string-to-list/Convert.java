/*

good for when you are reading lists -- ensures that double digit numbers are not split
(you may also have to clean it up to remove the {} and anything other attached)



*/


import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.util.List;
import java.util.Arrays;


public class Convert {

    public static void main(String[] args ) {

        // testing turning a string into an array 
        String stringOfNums = "2,3,11,12";
        String str[] = stringOfNums.split(",");
        List<String> al = new ArrayList<String>();
        al = Arrays.asList(str);

        System.out.println(al);




    }
    
}
