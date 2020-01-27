package com.epam.task15;

import java.util.Scanner;

/* 4. Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):  1     1    1   ...   1    1   1
                                                                                   2     2    2   ...   2    2   0
                                                                                   3     3    3   ...   3    0   0
                                                                                   .     .    .    .    .    .   .
                                                                                   .     .    .     .   .    .   .
                                                                                   .     .    .      .  .    .   .
                                                                                  n-1   n-1   0   ...   0    0   0
                                                                                   n     0    0   ...   0    0   0
*/
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("size: ");
        int size = in.nextInt();

        int[][] matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = i + 1;
            }
        }

        for (int i = 1; i < size; i++) {
            for (int j = size - 1; j >= size - i; j--) {
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
