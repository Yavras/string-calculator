package calculator;


public class StringCalculator {

     public static int add(String text) {

         String regex = "(.)[,](.)|(.)\\n(.*)";
         boolean valid = text.matches(regex);

        if(text.isEmpty()) {
             return 0;
         } else if(valid) {

             String[] parts = text.split(",|\\n");
             int sum=0;
             for (String part : parts)
             {
                 sum = sum + Integer.parseInt(part);
             }
             return sum;

         } else {
             return Integer.parseInt(text);
         }
     }
}
