package com.epam.task16;

import java.util.Scanner;

/* 4. Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):  1     1    1   ...   1    1   1
                                                                                   0     1    1   ...   1    1   0
                                                                                   0     0    1   ...   1    0   0
                                                                                   .     .    .    .    .    .   .
                                                                                   .     .    .     .   .    .   .
                                                                                   .     .    .      .  .    .   .
                                                                                   0     1    1   ...   1    1   0
                                                                                   1     1    1   ...   1    1   1
*/
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("size: ");
        int size = in.nextInt();

        int[][] matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = 1;
            }
        }

        // Зануляем верхнюю левую половину матрицы.
        for (int i = 1; i <= size / 2; i++) {
            for (int j = 0; j < i; j++) {
                matrix[i][j] = 0;
            }
        }

        // Зануляем верхнюю правую половину матрицы.
        for (int i = 1; i <= size / 2; i++) {
            for (int j = size - 1; j >= size - i; j--) {
                matrix[i][j] = 0;
            }
        }

        // Зануляем нижнюю левую половину матрицы.
        for (int i = size - 2; i >= size / 2; i--) {
            for (int j = 0; j < size - 1 - i; j++) {
                matrix[i][j] = 0;
            }
        }

        // Зануляем нижнюю правую половину матрицы.
        for (int i = size - 2; i >= size / 2; i--) {
            for (int j = size - 1; j >= i + 1; j--) {
                matrix[i][j] = 0;
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + "\t\t");
            }
            System.out.println();
        }
    }
}
