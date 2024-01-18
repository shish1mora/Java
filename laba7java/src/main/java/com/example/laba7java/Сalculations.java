package com.example.laba7java;

import java.lang.invoke.CallSite;

public class Сalculations {
    public double calculatePerimeter(double side1, double side2, double angle) {
        return side1 + side2 + Math.sqrt(Math.pow(side1, 2) + Math.pow(side2, 2) - 2 * side1 * side2 * Math.cos(angle));
    }

    public double calculateArea(double side1, double side2, double angle) {
        return 0.5 * side1 * side2 * Math.sin(angle);
    }
}
