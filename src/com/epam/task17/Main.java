package com.epam.task17;

import java.util.Scanner;

/* 7. Сформировать квадратную матрицу порядка N по правилу: A[I,J] = sin( ( (I)^2 - (J^2) ) / N) и
    подсчитать количество положительных элементов в ней. */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("size: ");
        int size = in.nextInt();

        double[][] matrix = new double[size][size];

        int count = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = matrixElement(i, j, size);
                if (matrix[i][j] > 0) {
                    count++;
                }
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + "\t\t");
            }
            System.out.println();
        }

        System.out.println("\nКоличество положительных элементов: " + count);
    }

    public static double matrixElement(double i, double j, double size) {
        return round((Math.sin((i * i - j * j) / size)), 3);
    }

    public static double round(double number, int numeralsAmount) {
        double a = Math.pow(10, numeralsAmount);
        return Math.round(number * a) / a;
    }
}
