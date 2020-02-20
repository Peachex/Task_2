package com.epam.task37;

import java.util.Scanner;

// 3. Вычислить площадь правильного шестиугольника со стороной а, используя метод вычисления площади треугольника.
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("a = ");
        double a = in.nextDouble();

        double square = findSquare(a) * 6;

        System.out.println("\nSquare = " + square);
    }

    public static double findSquare(double a) {
        return (Math.sqrt(3) * a * a / 4);
    }
}
