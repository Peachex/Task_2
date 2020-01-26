package com.epam.task7;

import java.util.Scanner;

/* 7. Даны действительные числа a(1), a(2),...,a(n). Найти max(a(1) + a(2 * n), a(2) + a(2 * n - 1),...,a(n) + a(n + 1). */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("size: ");
        int size = in.nextInt();

        double[] array1 = new double[size];

        for (int i = 0; i < size; i++) {
            array1[i] = (Math.random() * 50 + 1) - 25;
            System.out.print(array1[i] + " ");
        }

        double[] array2 = new double[size];

        for (int i = 0; i < size - 1; i++) {
            array2[i] = array1[i] + array1[i + 1];
        }

        System.out.println("\n" + findMax(array2));
    }

    public static double findMax(double[] array) {
        double maxElement = array[0];

        for (int i = 0; i < array.length; i++) {
            if (array[i] > maxElement) {
                maxElement = array[i];
            }
        }

        return maxElement;
    }
}
