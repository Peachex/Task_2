package com.epam.task28;

import java.util.Random;
import java.util.Scanner;

/* 2. Даны две последовательности a1 <= a2 <= ... <= an и b1 <= b2 <= ... <= bm. Образовать из них новую последовательность
   чисел так, чтобы она тоже была неубывающей. Примечание. Дополнительный массив не использовать.  */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random random = new Random();

        System.out.print("size1, size2: ");
        int size1 = in.nextInt();
        int size2 = in.nextInt();

        int[] array1 = new int[size1];
        int[] array2 = new int[size2];

        for (int i = 0; i < Math.max(size1, size2); i++) {
            if (i < size1) {
                array1[i] = random.nextInt(31) - 15;
            }
            if (i < size2) {
                array2[i] = random.nextInt(21) - 10;
            }
        }

        System.out.print("Первая последовательность: ");
        sort(array1, size1);
        viewArray(array1, size1);

        System.out.print("Вторая последовательность: ");
        sort(array2, size2);
        viewArray(array2, size2);

        int size = size1 + size2;
        int[] array = new int[size];

        int i1 = 0;
        int i2 = 0;
        for (int i = 0; i < size; i++) {
            if (i1 < size1) {
                array[i] = array1[i1];
                i1++;
            } else {
                array[i] = array2[i2];
                i2++;
            }
        }

        sort(array, size);
        System.out.println();
        viewArray(array, size);
    }

    public static void viewArray(int[] array, int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println();
    }

    public static void sort(int[] array, int size) {
        int temp;
        for (int count = 0; count < size - 1; count++) {
            for (int i = 0; i < size - 1; i++) {
                if (array[i] > array[i + 1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
        }
    }
}
