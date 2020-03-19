package com.epam.task27;

import java.util.Random;
import java.util.Scanner;

/* 1. Заданы два одномерных массива с различным количеством элементов и натуральное число k. Объединить их в
      один  массив,  включив  второй  массив  между  k-м  и  (k+1)  -  м  элементами  первого,  при  этом  не  используя
      дополнительный массив. */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Размер первого и второго массива: ");
        int size1 = in.nextInt();
        int size2 = in.nextInt();
        int[] array1 = new int[size1];
        int[] array2 = new int[size2];

        for (int i = 0; i < Math.max(size1, size2); i++) {
            if (i < size1) {
                array1[i] = random.nextInt(21) - 10;
            }
            if (i < size2) {
                array2[i] = random.nextInt(21) - 10;
            }
        }

        System.out.print("Первый массив: ");
        viewArray(array1, size1);
        System.out.print("Второй массив: ");
        viewArray(array2, size2);

        System.out.print("Введите k, где k < " + size1 + " и k > 0" + " = ");
        int k = in.nextInt();

        int size = size1 + size2;
        int[] array = new int[size];

        int i1 = 0;
        int i2 = 0;
        for (int i = 0; i < size; i++) {
            if (i < k || i2 >= size2) {
                array[i] = array1[i1];
                i1++;
            } else {
                if (i == k || i2 < size2) {
                    array[i] = array2[i2];
                    i2++;
                }
            }
        }
        viewArray(array, size);
    }

    public static void viewArray(int[] array, int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println();
    }
}
