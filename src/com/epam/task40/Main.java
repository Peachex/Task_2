package com.epam.task40;

import java.util.Scanner;

// 6. Написать метод(методы), проверяющий, являются ли данные три числа взаимно простыми.
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите три числа: ");

        double number1 = in.nextDouble();
        double number2 = in.nextDouble();
        double number3 = in.nextDouble();

        System.out.print("Числа простые: " + (checkCondition(number1) && checkCondition(number2) && checkCondition(number3)));
    }

    public static boolean checkCondition(double number) {
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
