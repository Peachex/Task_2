package com.epam.task33;

import java.util.Random;
import java.util.Scanner;

/* 7. Пусть даны две неубывающие последовательности действительных чисел a1 <= a2 <= ... <= an и b1 <= b2 <= ... <= bm.
   Требуется указать те места, на которые нужно вставлять элементы последовательности b1 <= b2 <= ... <= bm в первую последовательность
   так, чтобы новая последовательность оставалась возрастающей. */
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

        viewArray(array1, size1);
        viewArray(array2, size2);

        int j = 0;
        for (int i = 0; i < size1 && j < size2; i++) {
            while (j < size2 && array2[j] <= array1[0]) {
                System.out.print("\n" + array2[j] + " должно быть перед первым элементом (" + array1[0] + ")");
                j++;
            }

            while (j < size2 && array2[j] >= array1[size1 - 1]) {
                System.out.print("\n" + array2[j] + " должно быть после последнего элемента (" + array1[size1 - 1] + ")");
                j++;
            }

            while (j < size2 && array2[j] < array1[i]) {
                System.out.print("\n" + array2[j] + " должно быть между " + (i) + "-ым и " + (i + 1) + "-ым элементом (" + array1[i - 1] + " и " + array1[i] + ")");
                j++;
            }
        }

        System.out.println();
    }

    public static void viewArray(int[] array, int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println();
    }
}
