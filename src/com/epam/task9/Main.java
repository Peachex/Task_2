package com.epam.task9;

import java.util.Scanner;

/* 9. В массиве целых чисел с количеством элементов n найти наиболее часто встречающееся число. Если таких
чисел несколько, то определить наименьшее из них. */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("size: ");
        int size = in.nextInt();

        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * 50 + 1) - 25;
            System.out.print(array[i] + " ");
        }

        int count, maxCount = 0, maxIndex = 0;

        for (int i = 0; i < size; i++) {
            count = 0;

            for (int j = 0; j < size; j++) {
                if (array[i] == array[j]) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                maxIndex = i;
                continue;
            }
            if (count == maxCount && array[i] < array[maxCount]) {
                maxCount = count;
                maxIndex = i;
            }
        }

        System.out.println("\nНаиболее часто встречающееся число = " + array[maxIndex] + "\nПовторов: " + maxCount);
    }
}
