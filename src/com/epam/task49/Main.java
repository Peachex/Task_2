package com.epam.task49;

import java.util.Scanner;

/* 15. Найти все натуральные n-значные числа, цифры в которых образуют строго возрастающую
   последовательность (например, 1234, 5789). Для решения задачи использовать декомпозицию. */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("n: ");
        int n = in.nextInt();

        for (int i = (int) Math.pow(10, n); i < (int) Math.pow(10, n + 1); i++) {
            if (checkNumber(i)) {
                System.out.print(i + "\t");
            }
        }
        System.out.println();
    }

    public static int numeral(int number, int count, int length) {
        return (int) (number / (length / Math.pow(10, count)));
    }

    public static boolean checkNumber(int number) {
        int size = (int) Math.log10(number);

        int length = (int) (Math.pow(10, (int) Math.log10(number)));

        int numeral1;
        int numeral2;

        for (int i = 0; i < size; i++) {
            numeral1 = numeral(number, i, length);
            number -= numeral1 * length / Math.pow(10, i);
            numeral2 = numeral(number, i + 1, length);

            if (numeral2 - numeral1 <= 0) {
                return false;
            }
        }

        return true;
    }
}
