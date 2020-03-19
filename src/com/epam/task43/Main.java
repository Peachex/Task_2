package com.epam.task43;

import java.util.Scanner;

/* 9. Даны числа X, Y, Z, Т — длины сторон четырехугольника. Написать метод(методы) вычисления его площади,
   если угол между сторонами длиной X и Y— прямой. */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("X, Y, Z, T: ");

        double x = in.nextDouble();
        double y = in.nextDouble();
        double z = in.nextDouble();
        double t = in.nextDouble();

        System.out.println("\nS = " + findSquare(x, y, z, t));
    }

    public static double findSquare(double x, double y, double z, double t) {
        double square1 = x * y / 2;

        double p = (z + t + (Math.sqrt(x * x + y * y))) / 2;

        double square2 = Math.sqrt(p * (p - Math.sqrt(x * x + y * y)) * (p - z) * (p - t)); // формула Герона.

        return square1 + square2;
    }
}
