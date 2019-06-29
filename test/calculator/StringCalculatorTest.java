package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest
{
    // first test point

    @Test
    public void methodShouldReturnZeroOnEmptyString()
    {
        assertEquals(0, StringCalculator.add(""));
    }

    @Test
    public void methodShouldReturnItself()
    {
        assertEquals(8, StringCalculator.add("8"));
    }

    @Test
    public void methodShouldReturnSumOfTwoNumbers()
    {
        assertEquals(10, StringCalculator.add("3,7"));
    }
}