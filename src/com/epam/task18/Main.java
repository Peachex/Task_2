package com.epam.task18;

import java.util.Random;
import java.util.Scanner;

/* 8. В числовой матрице поменять местами два столбца любых столбца, т. е. все элементы одного столбца поставить
на соответствующие им позиции другого, а его элементы второго переместить в первый. Номера столбцов вводит
пользователь с клавиатуры. */
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

        System.out.print("\nВведите номера двух столбцов для перестановки: ");
        int n1 = in.nextInt() - 1, n2 = in.nextInt() - 1, temp;

        for (int i = 0; i < size; i++) {
            temp = matrix[i][n1];
            matrix[i][n1] = matrix[i][n2];
            matrix[i][n2] = temp;
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + "\t\t");
            }
            System.out.println();
        }
    }
}
