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

        for (int i = 0; i < Math.max(size1, size2); i++) {
            if (i < size1) {
                array1[i] = random.nextInt(20) - 10;
            }
            if (i < size2) {
                array2[i] = random.nextInt(20) - 10;
            }
        }

        sortArray(array1, size1);
        viewArray(array1, size1);

        sortArray(array2, size2);
        viewArray(array2, size2);

        for (int i = 0; i < size2; i++) {
            findPlace(array1, size1, array2[i]);
        }

        System.out.println();
    }

    public static void viewArray(int[] array, int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println();
    }

    public static void findPlace(int[] array, int size, int number) {
        if (number <= array[0]) {
            System.out.print("\n" + number + " должно быть перед первым элементом (" + array[0] + ")");
            return;
        }

        if (number >= array[size - 1]) {
            System.out.print("\n" + number + " должно быть после последнего элемента (" + array[size - 1] + ")");
            return;
        }

        for (int i = 1; i < size - 1; i++) {
            if (number >= array[i] && number <= array[i + 1]) {
                System.out.print("\n" + number + " должно быть между " + (i + 1) + "-ым и " + (i + 2) + "-ым элементом (" + array[i] + " и " + array[i + 1] + ")");
                break;
            }
        }
    }

    public static void sortArray(int[] array, int size) {
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
