package com.epam.task22;

import java.util.Random;
import java.util.Scanner;

// 12. Отсортировать строки матрицы по возрастанию и убыванию значений элементов.
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random random = new Random();

        System.out.print("size: ");
        int size = in.nextInt();

        int[][] matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = random.nextInt(29) + 1;
                System.out.print(matrix[i][j] + "\t\t");
            }
            System.out.println();
        }
        System.out.println();

        System.out.print("Введите номер столбца, относительно которого будет выполняться сортировка: ");
        int number = in.nextInt() - 1;
        int[] temp;

        for (int count = 0; count < size - 1; count++) {
            for (int i = 0; i < size - 1; i++) {
                if (matrix[i][number] > matrix[i + 1][number]) {
                    temp = matrix[i];
                    matrix[i] = matrix[i + 1];
                    matrix[i + 1] = temp;
                }
            }
        }

        System.out.println("Сортировка строк матрицы по возрастанию значений элементов: ");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + "\t\t");
            }
            System.out.println();
        }
        System.out.println();

        for (int count = 0; count < size - 1; count++) {
            for (int i = 0; i < size - 1; i++) {
                if (matrix[i][number] < matrix[i + 1][number]) {
                    temp = matrix[i];
                    matrix[i] = matrix[i + 1];
                    matrix[i + 1] = temp;
                }
            }
        }

        System.out.println("Сортировка строк матрицы по убыванию значений элементов: ");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + "\t\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}
