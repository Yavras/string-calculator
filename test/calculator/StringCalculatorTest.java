package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest
{
    // first test point

    @Test
    public void methodShouldReturnZeroOnEmptyString() throws Exception
    {
        assertEquals(0, StringCalculator.add(""));
    }

    @Test
    public void methodShouldReturnItself() throws Exception
    {
        assertEquals(7, StringCalculator.add("7"));
    }

    @Test
    public void methodShouldReturnSumOfTwoNumbers() throws Exception
    {
        assertEquals(10, StringCalculator.add("3,7"));
    }

    // second test point

    @Test
    public void methodShouldReturnSumOfAnyAmountNumbers() throws Exception
    {
        assertEquals(22, StringCalculator.add("3\n7,11,1"));
    }

    // third test point

    @Test
    public void methodShouldReturnSumOfNumbersSplittedByComaOrNewLine() throws Exception
    {
        assertEquals(11, StringCalculator.add("3\n6,2"));
    }

    // fourth test point
    @Test
    public void methodShouldReturnSumOfNumbersSplittedByDifferentDelimiter_v1() throws Exception
    {
        assertEquals(25, StringCalculator.add("//@@\n6@@9@@8@@2"));
    }

    @Test
    public void methodShouldReturnSumOfNumbersSplittedByDifferentDelimiter_v2() throws Exception
    {
        assertEquals(25, StringCalculator.add("//;\n6;9;8;2"));
    }

    @Test
    public void methodShouldReturnSumOfNumbersSplittedByDifferentDelimiterSpecialCharacter() throws Exception
    {
        assertEquals(18, StringCalculator.add("//.\n5.11.2"));
    }

    // fifth test point

    @Test
    public void methodShouldReturnExceptionOnNegatives_v1()
    {
       Exception e = assertThrows(Exception.class,
               ()->{
           StringCalculator.add("-1,4,-7");

               });

       assertEquals("negatives not allowed: [-1, -7]", e.getMessage());
    }

    @Test
    public void methodShouldReturnExceptionOnNegatives_v2()
    {
        Exception e = assertThrows(Exception.class,
                ()->{
                    StringCalculator.add("//.\n5.11.-2.2");

                });

        assertEquals("negatives not allowed: [-2]", e.getMessage());
    }

    @Test
    public void methodShouldReturnSumOfNumbersSplittedByComaOrNewLine22() throws Exception
    {
        assertEquals(3, StringCalculator.add("1005,3"));
    }

}
