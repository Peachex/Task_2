package com.epam.task36;

import java.util.Scanner;

// 2. Написать метод(методы) для нахождения наибольшего общего делителя четырех натуральных чисел.
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите четыре числа: ");

        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        int d = in.nextInt();

        int maxDivider = isDivider(a, b, c, d);

        System.out.println("Числа: " + a + ", " + b + ", " + c + ", " + d + "\nНОД = " + maxDivider);
    }

    public static int isDivider(int a, int b, int c, int d) {
        int maxDivider = 1;
        for (int i = 1; i <= (Math.min(Math.min(a, b), Math.min(c, d))); i++) {
            if (a % i == 0 && b % i == 0 && c % i == 0 && d % i == 0) {
                maxDivider = i;
            }
        }
        return maxDivider;
    }
}
