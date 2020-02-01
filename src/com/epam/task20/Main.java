package com.epam.task20;

import java.util.Random;
import java.util.Scanner;

// 10. Найти положительные элементы главной диагонали квадратной матрицы.
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random random = new Random();

        System.out.print("size: ");
        int size = in.nextInt();

        int[][] matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = random.nextInt(31) - 15;
                System.out.print(matrix[i][j] + "\t\t");
            }
            System.out.println();
        }

        System.out.print("\nПоложительные элементы главной диагонали квадратной матрицы: ");
        for (int i = 0; i < size; i++) {
            if (matrix[i][i] > 0) {
                System.out.print(matrix[i][i] + "\t");
            }
        }
        System.out.println();
    }
}
