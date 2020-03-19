package com.epam.task19;

import java.util.Random;
import java.util.Scanner;

/* 9. Задана матрица неотрицательных чисел. Посчитать сумму элементов в каждом столбце. Определить, какой
      столбец содержит максимальную сумму. */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random random = new Random();

        System.out.print("size: ");
        int size = in.nextInt();

        int[][] matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = random.nextInt(16);
                System.out.print(matrix[i][j] + "\t\t");
            }
            System.out.println();
        }

        int sum;
        int maxSum = 0;
        int maxIndex = 0;
        for (int j = 0; j < size; j++) {
            sum = 0;
            for (int i = 0; i < size; i++) {
                sum += matrix[i][j];
            }
            if (sum > maxSum) {
                maxSum = sum;
                maxIndex = j + 1;
            }
        }

        System.out.println("\nСтолбец номер " + maxIndex + " содержит максимальную сумму = " + maxSum);
    }
}
