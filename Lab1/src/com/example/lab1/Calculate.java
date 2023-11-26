package com.example.lab1;

public class Calculate {
    public static double calcA(int x, int y) throws ArithmeticException {
        double res = 0;
        double firstSummand = Math.pow(y, x);
        double secondSummand = (double) 1 / ((2 * y) * ((double) 3 / x));
        res = firstSummand + secondSummand;
        if (Double.isInfinite(res) || Double.isNaN(res)) {
            throw new ArithmeticException("Ошибка: некорректный результат вычислений");
        }
        return res;
    }

    public static double calcB(int x, double a) throws ArithmeticException {
        double res = 0;
        double firstSummand = Math.pow(a, x);
        double secondSummand = Math.sqrt(4) / (Math.sqrt(2) + (double) 3 / x);
        res = firstSummand + secondSummand;
        if (Double.isInfinite(res) || Double.isNaN(res)) {
            throw new ArithmeticException("Ошибка: некорректный результат вычислений");
        }
        return res;
    }
}

