package com.epam.task42;

import java.util.Random;
import java.util.Scanner;

/* 8. Задан массив D. Определить следующие суммы: D[l] + D[2] + D[3]; D[3] + D[4] + D[5]; D[4] +D[5] +D[6].
   Пояснение. Составить метод(методы) для вычисления суммы трех последовательно расположенных элементов массива с номерами от k до m. */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Размер массива: ");
        int size = in.nextInt();

        int[] array = new int[size];

        System.out.println("Массив: ");
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(21) - 10;
            System.out.print(array[i] + "\t");
        }

        System.out.print("\nВведите k и m: ");
        int k = in.nextInt();
        int m = in.nextInt();

        findSum(array, k, m);
    }

    public static void findSum(int[] array, int k, int m) {
        System.out.print("\nСумма: " + array[k - 1] + ", " + array[k] + ", " + array[m - 1] + " = " + plus(array, k));
        System.out.println();
    }


    public static int plus(int[] array, int i) {
        return (array[i - 1] + array[i] + array[i + 1]);
    }
}
