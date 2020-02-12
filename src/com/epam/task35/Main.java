package com.epam.task35;

import java.util.Scanner;

/* 1. Написать метод(методы) для нахождения наибольшего общего делителя и наименьшего общего кратного двух
   натуральных чисел: ( НОК(A, B) = (A * B) / НОД(A, B) ) .  */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите два числа: ");

        int a = in.nextInt();
        int b = in.nextInt();

        int nod = 1;
        for (int i = 1; i <= Math.min(a, b); i++) {
            if (findNod(a, b, i)) {
                nod = i;
            }
        }

        int nok = findNok(a, b, nod);

        System.out.println("Числа: " + a + ", " + b + "\nНОД = " + nod + "\nНОК = " + nok);
    }

    public static boolean findNod(int a, int b, int number) {
        return (a % number == 0 && b % number == 0);
    }

    public static int findNok(int a, int b, int nod) {
        return (a * b / nod);
    }
}
