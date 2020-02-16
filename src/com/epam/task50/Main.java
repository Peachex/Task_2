package com.epam.task50;

import java.util.Scanner;

/* 16. Написать программу, определяющую сумму n - значных чисел, содержащих только нечетные цифры.
   Определить также, сколько четных цифр в найденной сумме. Для решения задачи использовать декомпозицию. */
public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.print("n: ");
        int n = in.nextInt();

        int sum = 0;

        System.out.println("Числа, содержащие только нечетные цифры: ");
        for (int i = (int) Math.pow(10, n); i < (int) Math.pow(10, n + 1); i++) {
            if (checkNumber(i)) {
                System.out.print(i + "\t");
                sum += i;
            }
        }
        System.out.println("\nСумма = " + sum);
    }

    public static int numeral(int number, int count, int length) {
        return (int) (number / (length / Math.pow(10, count)));
    }

    public static boolean checkNumber(int number) {
        int size;
        size = (int) Math.log10(number);

        int length;
        length = (int) (Math.pow(10, (int) Math.log10(number)));

        int numeral1;

        for (int i = 0; i <= size; i++) {
            numeral1 = numeral(number, i, length);
            number -= numeral1 * length / Math.pow(10, i);

            if (numeral1 % 2 == 0) {
                return false;
            }
        }

        return true;
    }
}
