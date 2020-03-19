package com.epam.task48;

import java.util.Scanner;

/* 14. Натуральное число, в записи которого n цифр, называется числом Армстронга, если сумма его цифр, возведенная в степень n,
   равна самому числу. Найти все числа Армстронга от 1 до k. Для решения задачи использовать декомпозицию. */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("k: ");
        int k = in.nextInt();

        System.out.println("Числа Армстронга: ");
        for (int i = 1; i < k; i++) {
            if (findNumber(i)) {
                System.out.print(i + "\n");
            }
        }
    }

    public static boolean findNumber(int number) {
        return (numeralsSum(number) == number);
    }

    public static int numeral(int number, int count, int length) {
        return (int) (number / (length / Math.pow(10, count)));
    }

    public static int numeralsSum(int number) {
        int size = (int) Math.log10(number);

        int length = (int) (Math.pow(10, (int) Math.log10(number)));

        int sum = 0;
        for (int i = 0; i <= size; i++) {
            sum += Math.pow(numeral(number, i, length), size + 1);
            number -= numeral(number, i, length) * length / Math.pow(10, i);
        }

        return sum;
    }
}
