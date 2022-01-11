public class test {
    
    public static void main(String[] args) {
        
        String tempType = "C";
        Double heatIndex = 79.0;
        
        if (tempType.equals("C")) {
            double multiplier = 5.0/9.0;
            heatIndex = (heatIndex - 32) * multiplier ;
        }

        System.out.println(heatIndex);

    }
}
