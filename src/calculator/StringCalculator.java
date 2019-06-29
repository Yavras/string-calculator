package calculator;

public class StringCalculator
{
     public static int add(String text)
     {
         if (text.isEmpty())
         {
             return 0;
         }
         else if (text.contains(","))
         {
             String[] parts = text.split(",");
             return Integer.parseInt(parts[0]) + Integer.parseInt(parts[1]);
         }
         else
         {
             return Integer.parseInt(text);
         }
     }
}
