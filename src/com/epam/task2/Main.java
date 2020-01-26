package com.epam.task2;

import java.util.Scanner;

/* 2. Дана последовательность действительных чисел а(1)  ,а(2)  ,..., а(n). Заменить все ее члены, большие данного Z, этим
числом. Подсчитать количество замен. */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("size: ");
        int size = in.nextInt();

        double[] array = new double[size];

        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * 50 + 1) - 25;
            System.out.print(array[i] + "  ");
        }

        System.out.print("\nZ: ");
        double z = in.nextDouble();

        int count = 0;
        for (int i = 0; i < size; i++) {
            if (array[i] > z) {
                array[i] = z;
                count++;
            }
            System.out.print(array[i] + "  ");
        }

        System.out.println("\nКоличество замен = " + count);
    }
}
