package com.epam.task32;

import java.util.Random;
import java.util.Scanner;

/* 6. Сортировка Шелла. Дан массив n действительных чисел. Требуется упорядочить его по возрастанию. Делается это
   следующим образом: сравниваются два соседних элемента ai и a(i + 1). Если ai <= a(i + 1), то продвигаются на один
   элемент вперед. Если ai > a(i + 1), то производится перестановка и сдвигаются на один элемент назад. Составить алгоритм этой сортировки. */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random random = new Random();

        System.out.print("size: ");
        int size = in.nextInt();

        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(21) - 10;
            System.out.print(array[i] + "\t");
        }

        sort(array, size);
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println();
    }

    public static void sort(int[] array, int size) {
        int temp;

        for (int i = 0; i < size - 1; i++) {
            if (array[i] > array[i + 1]) {
                temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;

                if (i > 0) {
                    i -= 2;
                }
            }
        }
    }
}
