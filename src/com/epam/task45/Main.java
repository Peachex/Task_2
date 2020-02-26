package com.epam.task45;

import java.util.Scanner;

// 11. Написать метод(методы), определяющий, в каком из данных двух чисел больше цифр.
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите два числа: ");

        int number1 = in.nextInt();
        int number2 = in.nextInt();

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

    public static int numeralsAmount(int number) {
        return (int) (Math.log10(number));
    }
}
