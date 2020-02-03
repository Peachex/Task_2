package com.epam.task6;

import java.util.Random;
import java.util.Scanner;

/* 6.  Задана  последовательность  N  вещественных  чисел.  Вычислить  сумму  чисел,  порядковые  номера  которых
являются простыми числами. */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random random = new Random();

        System.out.print("size: ");
        int size = in.nextInt();

        double[] array = new double[size];

        for (int i = 0; i < size; i++) {
            if (random.nextInt(2) == 0) {
                array[i] = (int) (Math.random() * 50 + 1) - 25;
            } else {
                array[i] = (Math.random() * 50 + 1) - 25;
            }
            System.out.print(array[i] + "\t\t");
        }

        System.out.println();

        double sum = 0;
        for (int i = 0; i < size; i++) {
            if (checkNumber(i + 1)) {
                sum += array[i];
            }
        }
        System.out.println("\nСумма = " + sum);
    }

    public static boolean checkNumber(double number) {
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

}
