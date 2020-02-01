package com.epam.task21;

import java.util.Random;

/* 11. Матрицу 10x20 заполнить случайными числами от 0 до 15. Вывести на экран саму матрицу и номера строк, в
   которых число 5 встречается три и более раз. */
public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        int[][] matrix = new int[10][20];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                matrix[i][j] = random.nextInt(16);
                System.out.print(matrix[i][j] + "\t\t");
            }
            System.out.println();
        }

        System.out.println();

        int count;
        boolean flag = false;

        for (int i = 0; i < 10; i++) {
            count = 0;
            for (int j = 0; j < 20; j++) {
                if (matrix[i][j] == 5) {
                    count++;
                }
            }
            if (count >= 3) {
                flag = true;
                System.out.print((i + 1) + "\t");
            }
        }
        if (flag) {
            System.out.println(" - номера строк, в которых число 5 встречается три и более раз.");
        } else {
            System.out.println("Нет cтрок, в которых число 5 встречается три и более раз.");
        }
    }
}
