package com.epam.task45;

import java.util.Scanner;

// 11. Написать метод(методы), определяющий, в каком из данных двух чисел больше цифр.
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите два числа: ");

        double number1 = in.nextDouble();
        double number2 = in.nextDouble();

        System.out.println("Числа: " + number1 + "\t" + number2);

        if (numeralsAmount(number1) > numeralsAmount(number2)) {
            System.out.println("Количество цифр больше в числе: " + number1);
        } else {
            if (numeralsAmount(number1) < numeralsAmount(number2)) {
                System.out.println("Количество цифр больше в числе: " + number2);
            } else {
                System.out.println("Количество цифр одинаково.");
            }
        }
    }

    public static int numeralsAmount(double number) {
        String numberStr = String.valueOf(number);

        char[] numerals = numberStr.toCharArray();

        int j = numerals.length - 1;
        if (numerals.length > 7) {
            for (int i = numerals.length - 1; i >= 0; i--) {
                if (numerals[i] == 'E') {
                    j = i - 1;
                    break;
                }
            }
        }

        int count = 0;

        for (int i = j; i >= 0; i--) {
            if (numerals[i] == '0') {
                count++;
            } else {
                break;
            }
        }

        return (numerals.length - count - 1 - (numerals.length - j));
    }
}
