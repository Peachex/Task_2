package com.epam.task12;

import java.util.Scanner;

// 2. Дана квадратная матрица. Вывести на экран элементы, стоящие на диагонали.
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("size: ");
        int size = in.nextInt();

        int[][] matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = (int) (Math.random() * 21) - 10;
                System.out.print(matrix[i][j] + "\t\t");
            }
            System.out.println();
        }

        System.out.println("Главная диагональ: ");
        for (int i = 0; i < size; i++) {
            System.out.print(matrix[i][i] + "\t");
        }

        System.out.println("\nПобочная диагональ: ");
        for (int i = 0; i < size; i++) {
            System.out.print(matrix[i][size - i - 1] + "\t");
        }

        System.out.println();
    }
}
