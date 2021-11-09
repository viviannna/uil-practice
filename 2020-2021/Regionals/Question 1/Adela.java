// CONCLUSION: You COULD do it with loops, but just don't. It's much faster to just manually print it out.

public class Adela {
    public static void main(String[] args) {
        
        // top half (1-9)

        for (int rowNumber = 1; rowNumber <= 9; rowNumber++) {
            // number in rows
            for (int astInRow = 1; astInRow <= rowNumber; astInRow++) {
                System.out.print("*");
            }
            System.out.println("");
        }

        // bottom half (10-17)
        // this needs to be fixed, not working
        // for (int rowNumber = 10; rowNumber <=17; rowNumber ++) {
        //     for (int astInRow = 8; astInRow >= 1; astInRow-=1) {
        //         System.out.print("*");
        //     }

        //     System.out.println("");
        // }
        
    }
}
