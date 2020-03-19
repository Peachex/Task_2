package com.epam.task51;

import java.util.Scanner;

/* 17. Из заданного числа вычли сумму его цифр. Из результата вновь вычли сумму его цифр и т.д. Сколько таких
   действий надо произвести, чтобы получился нуль? Для решения задачи использовать декомпозицию. */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите число: ");
        int number = in.nextInt();

        int count = 0;

        while (number > 0) {
            number -= numeralsSum(number);
            count++;

            System.out.println(count + ") " + number);
        }
    }

    public static int numeral(int number, int count, int length) {
        return (int) (number / (length / Math.pow(10, count)));
    }

    public static int numeralsSum(int number) {
        int size = (int) Math.log10(number);

        int length = (int) (Math.pow(10, (int) Math.log10(number)));

        int sum = 0;
        for (int i = 0; i <= size; i++) {
            sum += numeral(number, i, length);
            number -= numeral(number, i, length) * length / Math.pow(10, i);
        }

        return sum;
    }
}
