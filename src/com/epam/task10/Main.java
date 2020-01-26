package com.epam.task10;

import java.util.Scanner;

/* 10. Дан целочисленный массив с количеством элементов n. Сжать массив, выбросив из него каждый второй
   элемент (освободившиеся элементы заполнить нулями). Примечание. Дополнительный массив не использовать. */
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

        for (int i = 1; i < size; i += 2) {
            array[i] = 0;
        }

        int temp;

        for (int count = 0; count < size - 1; count++) {
            for (int i = 0; i < size - 1; i++) {
                if (array[i] == 0) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
        }

        System.out.println();

        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
