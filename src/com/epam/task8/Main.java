package com.epam.task8;

import java.util.Random;
import java.util.Scanner;

/* 8. Дана последовательность целых чисел a(1), a(2), ..., a(n). Образовать новую последовательность,
   выбросив из исходной те члены, которые равны min(a(1), a(2), ..., a(n)). */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random random = new Random();

        System.out.print("size: ");
        int size = in.nextInt();

        int[] array1 = new int[size];

        for (int i = 0; i < size; i++) {
            array1[i] = random.nextInt(31) - 15;
            System.out.print(array1[i] + " ");
        }

        int minElement = findMin(array1);
        System.out.println("\nmin = " + minElement);

        int count = 0;
        int temp;

        for (int i = 0; i < size - count; i++) {
            while (i < (size - count) && array1[i + count] == minElement) {
                count++;
            }

            if (i < size - count) {
                temp = array1[i];
                array1[i] = array1[count + i];
                array1[count + i] = temp;
            }
        }

        int[] array2 = new int[size - count];

        for (int i = 0; i < size - count; i++) {
            array2[i] = array1[i];
            System.out.print(array2[i] + " ");
        }
    }

    public static int findMin(int[] array) {
        int minElement = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < minElement) {
                minElement = array[i];
            }
        }

        return minElement;
    }
}
