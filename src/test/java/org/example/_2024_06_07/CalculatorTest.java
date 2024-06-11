package org.example._2024_06_07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private final Calculator calculator = new Calculator();
    private final double a = 10;
    private final double b = 20;
    private final double bZero = 0;

    @Test
    void dividePositiveTest() {
        double expected = 0.5d;
        Assertions.assertEquals(expected, calculator.divide(a, b), 0.001);
    }

    @Test
    void divideWithExceptionTest() {
        Assertions.assertThrows(ArithmeticException.class, () -> calculator.divide(a, bZero));
    }

    @Test
    public void multTest() {
        double expectedMult = 200;


        Assertions.assertEquals(expectedMult, calculator.mult(a, b), 0.001);


    }

    @Test
    void subTest() {
        double expectedSubPositive = 10;
        double expectedSubNegative = -10;

        Assertions.assertEquals(expectedSubNegative, calculator.sub(a, b));
        Assertions.assertEquals(expectedSubPositive, calculator.sub(b, a));

    }

    @Test
    void powTest() {
        Assertions.assertEquals(8.0, calculator.pow(2.0, 3.0));
        Assertions.assertEquals(1.0, calculator.pow(2.0, 0.0));
        Assertions.assertEquals(0.25, calculator.pow(2.0, -2.0));
        Assertions.assertEquals(27.0, calculator.pow(3.0, 3.0));
    }


    @Test
    void sqrTest() {
        Assertions.assertEquals(4, calculator.sqr(2));
        Assertions.assertEquals(0, calculator.sqr(0));
        Assertions.assertEquals(1, calculator.sqr(1));
        Assertions.assertEquals(100, calculator.sqr(-10));
    }

    @Test
    void sqrtPositive() {
        Assertions.assertEquals(5, calculator.sqrt(25));
        Assertions.assertEquals(0, calculator.sqrt(0));

    }

    @Test
    void sqrtNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.sqrt(-5));

    }

    @Test
    void lnPositive() {
        Assertions.assertEquals(1, calculator.ln(Math.E));
        Assertions.assertEquals(0, calculator.ln(1));
    }

    @Test
    void lnNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.ln(-2));
    }

    @Test
    void sinTest() {
        Assertions.assertEquals(0, calculator.sin(0));
        Assertions.assertEquals(1, calculator.sin(Math.PI / 2));
//        Assertions.assertEquals(0, calculator.sin(Math.PI));
        Assertions.assertEquals(Math.sqrt(2) / 2, calculator.sin(Math.PI / 4), 0.001);
    }

    @Test
    void cos() {
        Assertions.assertEquals(1, calculator.cos(0));
//        Assertions.assertEquals(0, calculator.cos(Math.PI/2));
//        Assertions.assertEquals(-1, calculator.cos(Math.PI));
        Assertions.assertEquals(Math.sqrt(2) / 2, calculator.cos(Math.PI / 4), 0.001);
    }

    @Test
    void tanPositive() {
        Assertions.assertEquals(1, calculator.tan(Math.PI / 4), 0.001);
        Assertions.assertEquals(Math.sqrt(3), calculator.tan(Math.PI / 3), 0.001);
        Assertions.assertEquals(1 / Math.sqrt(3), calculator.tan(Math.PI / 6), 0.001);
    }

    @Test
    void tanNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.tan(Math.PI / 2));
    }

    @Test
    void ctanPositive() {
        Assertions.assertEquals(1, calculator.ctan(Math.PI / 4), 0.001);
        Assertions.assertEquals(1 / Math.sqrt(3), calculator.ctan(Math.PI / 3), 0.001);
        Assertions.assertEquals(Math.sqrt(3), calculator.ctan(Math.PI / 6), 0.001);
    }

    @Test
    void ctanNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.ctan(Math.PI));
    }
}