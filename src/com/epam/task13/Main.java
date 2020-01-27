package com.epam.task13;

import java.util.Scanner;

// 3. Дана матрица. Вывести k-ю строку и p-й столбец матрицы.
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("rows, cols: ");
        int rows = in.nextInt(), cols = in.nextInt();

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = (int) (Math.random() * 21) - 10;
                System.out.print(matrix[i][j] + "\t\t");
            }
            System.out.println();
        }

        System.out.println("Какую строку вывести?");
        int k = in.nextInt() - 1;

        for (int j = 0; j < cols; j++) {
            System.out.print(matrix[k][j] + "\t\t");
        }

        System.out.println("\nКакой столбец вывести?");
        int p = in.nextInt() - 1;

        for (int i = 0; i < rows; i++) {
            System.out.println(matrix[i][p]);
        }
    }
}
