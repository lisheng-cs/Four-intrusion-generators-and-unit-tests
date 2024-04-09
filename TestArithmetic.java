package cn.homework;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestArithmetic {
    @Test
    public void testSolve_GradeOutOfRange() {
        assertEquals("Test case for grade out of range", "暂无年级的习题，尽请期待!", Arithmetic.solve(7, 1));
    }
    @Test
    public void testGeneratesimple() {
        String result = Arithmetic.generatesimpel(20, 1, "+-");
        assertEquals("Test case for generating simple arithmetic", true, result.matches("\\d+[\\+\\-]\\d+"));
    }

    @Test
    public void testGenerateComplex() {
        String result = Arithmetic.generatecomplex(1000, 3, "+-*/");

        String regex = "\\((?:[\\d]+[+\\-*/])+[\\d]+(?:[+\\-*/][\\d]+)*\\)";
        assertEquals("Test case for generating complex arithmetic", false, result.matches(regex));
    }
}

