package cn.homework;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class OtherTest {

    @Test
    public void testCheck_ValidExpression() {
        // Test case for valid expression
        boolean result = other.check(new StringBuffer("3+10"), 20);
        assertEquals("Test case for valid expression", true, result);
        result = other.check(new StringBuffer("3+20-100"), 50);
        assertEquals("Test case for valid expression", false, result);
        result = other.check(new StringBuffer("(10+90)*(40/5)"), 100000);
        assertEquals("Test case for valid expression", true, result);
        result = other.check(new StringBuffer("(10+90)*(40/5)-1000000"), 100000);
        assertEquals("Test case for valid expression", false, result);
    }

    @Test
    public void testCheck_DivideByZero() {
        // Test case for division by zero
        StringBuffer expression = new StringBuffer("5/0");
        boolean result = other.check(expression, 100);
        assertEquals("Test case for division by zero", false, result);
    }
}
