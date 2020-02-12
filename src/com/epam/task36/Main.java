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

        int nod = 0;
        for (int i = 1; i <= (Math.min(Math.min(a, b), Math.min(c, d))); i++) {
            if (findNod(a, b, i) && findNod(c, d, i)) {
                nod = i;
            }
        }

        System.out.println("Числа: " + a + ", " + b + ", " + c + ", " + d + "\nНОД = " + nod);
    }

    public static boolean findNod(int a, int b, int number) {
        return (a % number == 0 && b % number == 0);
    }
}
