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

        array1[0] = random.nextInt(11);
        array2[0] = random.nextInt(11);

        for (int i = 1; i < Math.max(size1, size2); i++) {
            if (i < size1) {
                array1[i] = random.nextInt(11) + array1[i - 1];
            }
            if (i < size2) {
                array2[i] = random.nextInt(11) + array2[i - 1];
            }
        }

        System.out.print("Первая последовательность: ");
        viewArray(array1, size1);

        System.out.print("Вторая последовательность: ");
        viewArray(array2, size2);

        int size = size1 + size2;
        int[] array = new int[size];

        int i1 = 0;
        int i2 = 0;
        for (int i = 0; i < size; i++) {
            if (i1 < size1 && i2 < size2) {
                if (array1[i1] > array2[i2]) {
                    array[i] = array2[i2];
                    i2++;
                } else {
                    array[i] = array1[i1];
                    i1++;
                }
            } else {
                if (i1 < size1 && i2 >= size2) {
                    array[i] = array1[i1];
                    i1++;
                } else {
                    if (i1 >= size1 && i2 < size2) {
                        array[i] = array2[i2];
                        i2++;
                    }
                }
            }
        }

        System.out.println();
        viewArray(array, size);
    }

    public static void viewArray(int[] array, int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println();
    }
}
