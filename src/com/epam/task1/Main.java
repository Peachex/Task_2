package com.epam.task1;

import java.util.Scanner;

// 1. В массив A [N] занесены натуральные числа. Найти сумму тех элементов, которые кратны данному К.
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("size: ");
        int size = in.nextInt();

        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = 1 + (int) (Math.random() * 29);
            System.out.print(array[i] + " ");
        }

        System.out.print("\nK: ");
        int k = in.nextInt(), sum = 0;

        for (int i = 0; i < size; i++) {
            if (array[i] % k == 0) {
                sum += array[i];
            }
        }

        System.out.println("Сумма элементов, которые кратны " + k + " = " + sum);
    }
}
