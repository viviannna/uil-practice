import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;


public class Esteban {

    public static void main(String args[]) throws Exception{

        File file = new File("esteban.dat");
        Scanner sc = new Scanner(file);
        ArrayList<String> allData = new ArrayList<String>();

        while(sc.hasNextLine()){
            allData.add(sc.nextLine());
        }


        // for each line in the file
        for (int lineCount = 1; lineCount < allData.size(); lineCount ++ ) {

            // extract the necessary data
            String totalLine = allData.get(lineCount);
            String tempType = totalLine.substring(0,1);
            Double ambientTemp = Double.valueOf(totalLine.substring(2,4));
            
            Double humidity = Double.valueOf(totalLine.substring(5,7));
            
            Boolean valid = true;
            Double heatIndex = 0.0;



            // CALCULATIONS MUST BE DONE IN FARENHEIGHT -- if celcius, convert
            if (tempType.equals("C")) {
                ambientTemp *= 1.8;
                ambientTemp += 32;

            }

            // MAKE SURE THAT THE TEMPERATURE IS VALID (at or above 80)


                
            // CALCULATE HEAT INDEX
            heatIndex = -42.379;
            heatIndex += (2.04901523 * ambientTemp);
            heatIndex += (10.14333127 * humidity);
            heatIndex -= (0.22475541 * ambientTemp * humidity);
            heatIndex -= (6.83783 * Math.pow(10, -3) * Math.pow(ambientTemp, 2));
            heatIndex -= (5.481717 * Math.pow(10,-2) * Math.pow(humidity, 2));
            heatIndex += (1.22874 * Math.pow(10, -3) * Math.pow(ambientTemp, 2) * humidity);
            heatIndex += (8.5282 * Math.pow(10, -4) * ambientTemp * Math.pow(humidity, 2));
            heatIndex -= (1.99 * Math.pow(10, -6) * Math.pow(ambientTemp, 2) * Math.pow(humidity, 2)); 

            // MAKE ADJUSTMENTS TO THE HI INDEX IF NEEDED
            if (humidity < 13) {

                Double adjustment = ((13 - humidity) / 4);
                Double midMath = ambientTemp - 95;
                midMath = Math.abs(midMath);
                midMath = 17 - midMath; 
                midMath /= 17;

                adjustment *= Math.pow(midMath, 0.5);

                heatIndex -= adjustment; 

            }

            else if (humidity > 85) {

                Double adjustment = (humidity - 85);
                adjustment /= 10;
                adjustment *= ((87 - ambientTemp) / 5);

                heatIndex += adjustment;

            }

            // CHECK FOR INVALID RESULTS




            // OUTPUT

            // need to convert back to original tempType (so if celcius convert from farenheight to celcius)
            if (tempType.equals("C")) {
                double multiplier = 5.0/9.0;                    // don't forget about doubles/ints in java
                heatIndex = (heatIndex - 32) * multiplier ;
            }

            

            System.out.print("#"+lineCount+": ");
            System.out.printf("%.1f", heatIndex);
            System.out.print(" "+tempType);
            
            if (heatIndex > 140) {
                System.out.print(" INVALID");
            }
            else if (ambientTemp < 80) {
                System.out.print(" INVALID");
            }

            else if ((heatIndex < ambientTemp) && (humidity >= 40)) {
                System.out.print(" INVALID");
            }

            System.out.println();







    



    } // end of for each line





    sc.close();




    }

}
