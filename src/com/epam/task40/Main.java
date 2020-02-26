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

        System.out.print("Числа взаимно простые: " + (checkCondition(number1, number2, number3)));
    }

    public static boolean checkCondition(double number1, double number2, double number3) {
        return ((number1 % number2 != 0 && number1 % number3 != 0) && (number2 % number1 != 0 && number2 % number3 != 0) && (number3 % number1 != 0 && number3 % number2 != 0));
    }
}
