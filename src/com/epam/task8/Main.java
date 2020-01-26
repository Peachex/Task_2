package com.epam.task8;

import java.util.Scanner;

/* 8. Дана последовательность целых чисел a(1), a(2), ..., a(n). Образовать новую последовательность,
    выбросив из исходной те члены, которые равны min(a(1), a(2), ..., a(n)). */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("size: ");
        int size = in.nextInt();

        int[] array1 = new int[size];

        for (int i = 0; i < size; i++) {
            array1[i] = (int) (Math.random() * 50 + 1) - 25;
            System.out.print(array1[i] + " ");
        }

        int minElement = findMin(array1), temp;
        System.out.println("\nmin = " + minElement);

        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1; j++) {
                if (array1[j] == minElement) {
                    temp = array1[j];
                    array1[j] = array1[j + 1];
                    array1[j + 1] = temp;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < size; i++) {
            if (array1[i] == minElement) {
                count++;
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
