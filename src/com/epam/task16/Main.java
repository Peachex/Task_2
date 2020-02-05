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

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i < size / 2) {
                    if (j < i || j > size - i - 1) {
                        matrix[i][j] = 0;
                    }
                } else {
                    if (j < size - i - 1 || j > i) {
                        matrix[i][j] = 0;
                    }
                }
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
