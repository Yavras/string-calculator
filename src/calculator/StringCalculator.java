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
             int sum=0;
             for (String part : parts)
             {
                 sum = sum + Integer.parseInt(part);
             }
             return sum;
         }
         else
         {
             return Integer.parseInt(text);
         }
     }
}
