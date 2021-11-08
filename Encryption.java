import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;


public class Encryption {
    public static void main(String[] args) throws Exception {

        ArrayList<String> allData = new ArrayList<String>();
        ArrayList<String> encryptedCards = new ArrayList<String>();
       
        // READ THE FILE
        File file = new File("encryption.dat");
        Scanner readSc = new Scanner(file);

        while (readSc.hasNextLine()) {
            allData.add(readSc.nextLine());
        }

        

        // for each card number (starts at 1 to ignore the first)
        for (int b = 1; b < allData.size(); b++) {
            encrypt(allData.get(b), b);
        }



    } // end of class main

    public static void encrypt(String theCardNumber, int cardIteration) {
        
        // create an array with each number of the card, a seperate item
        ArrayList<Integer> cardNumber = new ArrayList<Integer>();
        
        
        for (int a = 0; a < (theCardNumber.length() - 1); a++) {
            int indivNum = Character.getNumericValue(theCardNumber.charAt(a));
            cardNumber.add(indivNum);
        }

        // for each digit d, substitute d = (d+7) mod 10
        for (int b = 0; b < cardNumber.size(); b++) {
            int newVal = (Integer.valueOf(cardNumber.get(b)) + 7) % 10;
            cardNumber.set(b, newVal);
        }

        // INTERCHANGE THE DIGITS
        for (int c = 0; c <= 12; c += 4){
            int firstIndx = c;
            int thirdIndx = c+2;
            int secondIndx = c+1;
            int fourthIndx = c+3;

            int firstDig = cardNumber.get(firstIndx);
            int thirdDig = cardNumber.get(thirdIndx);
            int secondDig = cardNumber.get(secondIndx);
            int fourthDig = cardNumber.get(fourthIndx);

            // interchange the first and third digits
            cardNumber.set(firstIndx, thirdDig);
            cardNumber.set(thirdIndx, firstDig);

            // interchange the second and the fourth digits
            cardNumber.set(secondIndx, fourthDig);
            cardNumber.set(fourthIndx, secondDig);

        }

        // bring the whole array into one string
        String encryptedCard = "";
        for (int d = 0; d < cardNumber.size(); d++) {
            encryptedCard = encryptedCard.concat(String.valueOf(cardNumber.get(d)));
        }
        
        System.out.println(encryptedCard);
    

    } // end of class encrypt
}