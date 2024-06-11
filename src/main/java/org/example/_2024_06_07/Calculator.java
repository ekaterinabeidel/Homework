package org.example._2024_06_07;

public class Calculator {

    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("*****Divide by zero*****");
        }

        return a / b;
    }

    public double sum(double a, double b) {
        return a + b;
    }

    public double sub(double a, double b) {
        return a - b;
    }

    public double mult(double a, double b) {
        return a * b;
    }

    public double pow(double a, double b) {
        return Math.pow(a, b);
    }

    public double sqr(double a) {
        return a * a;
    }

    public double sqrt(double a) {
        if (a < 0)
            throw new IllegalArgumentException("Извлечение квадратного корня из отрицательного числа невозможно");
        return Math.pow(a, 0.5);
    }

    public double ln(double a) {
        if (a < 0) throw new IllegalArgumentException("Подлогарифмическое выражение не может быть отрицательным");
        return Math.log(a);
    }

    public double sin(double a) {
        return Math.sin(a);
    }

    public double cos(double a) {
        return Math.cos(a);
    }

    public double tan(double a) {
        if (a == Math.PI / 2) {
            throw new IllegalArgumentException("Тангенс PI/2 c периодом PI*N, где N - целое число, не существует");
        }
        return Math.tan(a);
    }

    public double ctan(double a) {
        if (a == Math.PI) {
            throw new IllegalArgumentException("Kотангенс PI c периодом PI*N, где N - целое число, не существует");
        }
        return 1 / Math.tan(a);
    }
}