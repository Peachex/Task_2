package com.epam.task11;

import java.util.Scanner;

// 1. Дана матрица. Вывести на экран все нечетные столбцы, у которых первый элемент больше последнего.
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("rows, cols: ");
        int rows = in.nextInt(), cols = in.nextInt();

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = (int) (Math.random() * 21) - 10;
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + "\t\t");
            }
            System.out.println();
        }

        System.out.println();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j += 2) {
                if (matrix[0][j] > matrix[rows - 1][j]) {
                    System.out.print(matrix[i][j] + "\t\t");
                }
            }
            System.out.println();
        }
    }
}
