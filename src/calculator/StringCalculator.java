package calculator;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.MatchResult;

import static java.util.Arrays.stream;


public class StringCalculator {

    public static final String commaOrNewLineRegex = "(.)[,](.)|(.)\\n(.*)";
    public static final Pattern differentDelimiterPattern = Pattern.compile("//(.*)\n(.*)");
    public static final Pattern negativesRegex = Pattern.compile("(-[0-9]+)");
    public static final String findBigNumbersRegex = "(100[1-9]|10[1-9][0-9]|1[1-9][0-9]{2}|[2-9][0-9]{3,})";

    public static int add(String text) throws Exception {

        text=text.replaceAll(findBigNumbersRegex,"0");

        boolean commaOrNewLineCondition = text.matches(commaOrNewLineRegex);
        Matcher negatives = negativesRegex.matcher(text);
        boolean negativeFound = negatives.find();
        if(negativeFound) {
            return findNegativesAndThrowException(negatives);
        }
        if(text.isEmpty()){
            return 0;
        }  else if(commaOrNewLineCondition) {
            return splittedByCommaOrNewLine(text);

        } else if(text.startsWith("//")) {
            return splittedByDifferentDelimiterPattern(text);
        }
        else {
            return Integer.parseInt(text);
        }

    }


    private static int findNegativesAndThrowException(Matcher negatives) throws Exception {
        negatives.reset();
        List<String> allMatches = new ArrayList<String>();
        while (negatives.find())
        {
            allMatches.add(negatives.group());
        }
        throw new Exception("negatives not allowed: " + allMatches.toString());
    }


    private static int splittedByCommaOrNewLine(String text) {
        String[] parts = text.split(",|\\n");
        int sum=0;
        for (String part : parts)
        {
            sum = sum + Integer.parseInt(part);
        }
        return sum;
    }


    private static int splittedByDifferentDelimiterPattern(String text) {
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

}