package com.epam.task31;

import java.util.Random;
import java.util.Scanner;

/* 5. Сортировка вставками. Дана последовательность чисел a1, a2, ..., an. Требуется переставить числа в порядке возрастания. Делается это
      следующим образом. Пусть a1, a2, ..., ai - упорядоченная последовательность, т.е. a1 <= a2 <= ... <= an. Берется следующее число a(i + 1)
      и вставляется в последовательность так, чтобы новая последовательность была тоже возрастающей. Процесс производится до тех пор, пока все
      элементы от i + 1 до n не будут перебраны. Примечание. Место помещения очередного элемента в отсортированную часть производить с помощью
      двоичного поиска. Двоичный поиск оформить в виде отдельной функции. */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random random = new Random();

        System.out.print("size: ");
        int size = in.nextInt();

        int[] array = new int[size];

        System.out.println("Массив: ");
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(21) - 10;
            System.out.print(array[i] + "\t");
        }

        int index;

        for (int i = 1; i < size; i++) {
            index = binarySearch(array, array[i], i - 1);
            swap(array, index, i, array[i]);
        }

        System.out.println("\nОтсортированный массив: ");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + "\t");
        }
    }

    public static int binarySearch(int[] array, int key, int end) {
        int begin = 0;
        int middle = 0;

        while (begin <= end) {
            middle = (begin + end) / 2;

            if (key > array[middle]) {
                begin = middle + 1;
            } else {
                if (key < array[middle]) {
                    end = middle - 1;
                } else {
                    if (key == array[middle]) {
                        return middle + 1;
                    }
                }
            }
        }

        return (key >= array[middle] ? middle + 1 : middle);
    }

    public static void swap(int[] array, int begin, int end, int arrayElement) {
        for (int i = end; i > begin; i--) {
            array[i] = array[i - 1];
        }
        array[begin] = arrayElement;
    }
}
