package com.epam.task37;

import java.util.Scanner;

// 3. Вычислить площадь правильного шестиугольника со стороной а, используя метод вычисления площади треугольника.
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("a = ");
        double a = in.nextDouble();

        double square;
        square = findSquare(a);

        System.out.println("\nSquare = " + square);
    }

    public static double findSquare(double a) {
        double p;
        p = a * 3 / 2;

        return (6 * Math.sqrt(p * Math.pow((p - a), 3)));
    }
}
