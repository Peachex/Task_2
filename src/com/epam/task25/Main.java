package com.epam.task25;

import java.util.Random;
import java.util.Scanner;

// 15. Найдите наибольший элемент матрицы и заменить все нечетные элементы на него.
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random random = new Random();

        System.out.print("size rows, cols: ");
        int rows = in.nextInt(), cols = in.nextInt();

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(21) - 10;
                System.out.print(matrix[i][j] + "\t\t");
            }
            System.out.println();
        }

        int maxElement = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] > maxElement) {
                    maxElement = matrix[i][j];
                }
            }
        }
        System.out.println("\nMax element = " + maxElement);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] % 2 != 0) {
                    matrix[i][j] = maxElement;
                }
                System.out.print(matrix[i][j] + "\t\t");
            }
            System.out.println();
        }
    }
}
