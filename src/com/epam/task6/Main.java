package com.epam.task6;

import java.util.Scanner;

/* 6.  Задана  последовательность  N  вещественных  чисел.  Вычислить  сумму  чисел,  порядковые  номера  которых
являются простыми числами. */
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

        System.out.println();

        for (int i = 0; i < size; i++) {
            if (checkNumber(i)) {
                System.out.print(array[i] + "  ");
            }
        }
    }

    public static boolean checkNumber(double number) {
        int count = 1;
        for (int i = 2; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }
        return (count == 2);
    }
}
