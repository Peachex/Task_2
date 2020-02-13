package com.epam.task39;

import java.util.Random;
import java.util.Scanner;

/* 5. Составить программу, которая в массиве A[N] находит второе по величине число (вывести на печать число,
   которое меньше максимального элемента массива, но больше всех других элементов). */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Размер массива: ");
        int size = in.nextInt();

        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(21) - 10;
            System.out.print(array[i] + "\t");
        }

        int maxElementIndex = maxElement(array, size, 0);

        int temp;

        temp = array[0];
        array[0] = array[maxElementIndex];
        array[maxElementIndex] = temp;

        System.out.println("\n\nМаксимальный элемент массива = " + array[0]);

        maxElementIndex = maxElement(array, size, 1);

        System.out.println("\nЭлемент, который меньше максимального элемента массива, но больше всех других элементов = " + array[maxElementIndex]);
    }

    public static int maxElement(int[] array, int size, int i) {
        int maxElement = array[i];
        int maxElementIndex = i;

        for (int j = i; j < size; j++) {
            if (array[j] > maxElement) {
                maxElement = array[j];
                maxElementIndex = j;
            }
        }
        return maxElementIndex;
    }
}
