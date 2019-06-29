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
             String[] patrts = text.split(",");
             return Integer.parseInt(patrts[0]) + Integer.parseInt(patrts[1]);
         }
         else
         {
             return Integer.parseInt(text);
         }
     }
}
