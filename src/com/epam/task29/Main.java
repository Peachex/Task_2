package com.epam.task29;

import java.util.Random;
import java.util.Scanner;

/* 3. Сортировка выбором. Дана последовательность чисел a1 <= a2 <= ... <= an. Требуется переставить элементы так,
чтобы они были расположены по убыванию. Для этого в массиве, начиная с первого, выбирается наибольший
элемент и ставится на первое место, а первый - на место наибольшего. Затем, начиная со второго, эта процедура
повторяется. Написать алгоритм сортировки выбором. */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random random = new Random();

        System.out.print("size: ");
        int size = in.nextInt();

        int[] array = new int[size];

        array[0] = random.nextInt(11);

        for (int i = 1; i < size; i++) {
            array[i] = random.nextInt(11) + array[i - 1];
        }

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

        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + "\t");
        }

        sort(array, size);

        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + "\t");
        }
    }

    public static void sort(int[] array, int size) {
        int temp;
        int maxElement;
        int maxElementIndex;
        for (int i = 0; i < size; i++) {
            maxElement = array[i];
            maxElementIndex = i;
            for (int j = i; j < size; j++) {
                if (array[j] > maxElement) {
                    maxElement = array[j];
                    maxElementIndex = j;
                }
            }
            temp = array[i];
            array[i] = array[maxElementIndex];
            array[maxElementIndex] = temp;
        }
    }
}
