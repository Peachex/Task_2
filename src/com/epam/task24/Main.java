package com.epam.task24;

import java.util.Random;
import java.util.Scanner;

/* 14. Сформировать случайную матрицу m x n, состоящую из нулей и единиц, причем в каждом столбце число
   единиц равно номеру столбца. */

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random random = new Random();

        System.out.print("size m x n (m > n or m = n): ");
        int sizeM = in.nextInt(), sizeN = in.nextInt();

        int[][] matrix = new int[sizeM][sizeN];

        for (int i = 0; i < sizeM; i++) {
            for (int j = 0; j < sizeN; j++) {
                matrix[i][j] = 0;
            }
        }

        for (int j = 0; j < sizeN; j++) {
            for (int count = 0; count < j + 1; count++) {
                int i = random.nextInt(sizeM);
                if (matrix[i][j] == 1) {
                    count--;
                } else {
                    matrix[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < sizeM; i++) {
            for (int j = 0; j < sizeN; j++) {
                System.out.print(matrix[i][j] + "\t\t");
            }
            System.out.println();
        }
    }
}

