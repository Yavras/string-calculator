package calculator;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.MatchResult;

import static java.util.Arrays.stream;


public class StringCalculator {

    public static final String commaAndNewLineRegex = "(.)[,](.)|(.)\\n(.*)";
    public static final Pattern differentDelimiterPattern = Pattern.compile("//(.*)\n(.*)");
    public static final Pattern negativesRegex = Pattern.compile("(-[0-9]+)");

    public static int add(String text) throws Exception {
        boolean valid = text.matches(commaAndNewLineRegex);
        Matcher negatives = negativesRegex.matcher(text);
        boolean negativeCondition = negatives.find();
        if(negativeCondition) {
            negatives.reset();
            List<String> allMatches = new ArrayList<String>();
            while (negatives.find())
            {
                allMatches.add(negatives.group());
            }
            throw new Exception("negatives not allowed: " + allMatches.toString());
        }
        if(text.isEmpty()){
            return 0;
        }  else if(valid) {
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

            }else {
                throw new IllegalArgumentException();
            }
            final String[] ints = numbers.split((Pattern.quote(delimiterRegex)));
            return stream(ints)
                    .mapToInt(Integer::parseInt)
                    .sum();
        }
        else {
            return Integer.parseInt(text);
        }

    }

}