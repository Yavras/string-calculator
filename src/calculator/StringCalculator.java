package calculator;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Arrays.stream;


public class StringCalculator {

    public static final String commaAndNewLineRegex = "(.)[,](.)|(.)\\n(.*)";
    public static final Pattern differentDelimiterPattern = Pattern.compile("//(.*)\n(.*)");

    public static int add(String text) {
        boolean valid = text.matches(commaAndNewLineRegex);

        if(text.isEmpty()){
            return 0;
        } else if(valid) {

             String[] parts = text.split(",|\\n");
             int sum=0;
             for (String part : parts)
             {
                 sum = sum + Integer.parseInt(part);
             }
             return sum;

         } else if(text.startsWith("//")) {
            String delimiterRegex, numbers;
            final Matcher matcher = differentDelimiterPattern.matcher(text);
            if(matcher.find()){
                delimiterRegex = matcher.group(1);
                numbers = matcher.group(2);
                System.out.println(numbers);

            }else {
                throw new IllegalArgumentException();
            }
            final String[] ints = numbers.split((delimiterRegex));
            return stream(ints)
                    .mapToInt(Integer::parseInt)
                    .sum();
         }
        else {
            return Integer.parseInt(text);
        }
     }

}


//String differentDelimiterRegex = "^(.*)\\n";
// String differentDelimiterRegex = ";";

        /* if(text.startsWith("//"))
         {
             text=text.substring(2);

             String differentDelimiterRegex = "(.*)\n";
             boolean valid2 = text.matches(differentDelimiterRegex);
             int sum2=0;
             valid2=true;
             if (valid2)
             {
                 String[] part2 = text.split(";|\n");
                 for (String parts: part2)
                 {
                     sum2 = sum2 + Integer.parseInt(parts);
                 }
             }
             return sum2;
         }*/



/*
        if(text.startsWith("//")){
        text=text.substring(2);
        String[] tokens = text.split(differentDelimiterRegex);
        System.out.println("zadany string: "+text);
        for (String token:tokens) {
        System.out.println(token);
        }
        return 0;*/