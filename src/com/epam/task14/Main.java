package com.epam.task14;

import java.util.Scanner;

/* 4. Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):  1     2    3   ...   n
                                                                                   n    n-1  n-2  ...   1
                                                                                   1     2    3   ...   n
                                                                                   n    n-1  n-2  ...   1
                                                                                   .     .    .    .    .
                                                                                   .     .    .     .   .
                                                                                   .     .    .      .  .
                                                                                   n    n-1  n-2  ...   1
*/
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("size: ");
        int size = in.nextInt();

        int[][] matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i % 2 == 0) {
                    matrix[i][j] = j + 1;
                } else {
                    matrix[i][j] = size - j;
                }
                System.out.print(matrix[i][j] + "\t\t");
            }
            System.out.println();
        }
    }
}
