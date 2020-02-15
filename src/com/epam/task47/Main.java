package com.epam.task47;

import java.util.Scanner;

/* 13. Два простых числа называются «близнецами», если они отличаются друг от друга на 2 (например, 41 и 43).
Найти и напечатать все пары «близнецов» из отрезка [n, 2n], где n - заданное натуральное число больше 2. Для
решения задачи использовать декомпозицию. */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Размер массива: ");
        int size = in.nextInt();

        System.out.println("Числа: ");
        for (int i = size; i < size * 2; i++) {
            System.out.print(i + "\t");
        }

        System.out.println("\n\nПары: ");
        for (int i = size; i < size * 2; i++) {
            findTwins(i, size);
        }
        System.out.println();
    }

    public static void findTwins(int number, int size) {
        for (int i = size; i <= size * 2; i++) {
            if (i - number == 2) {
                System.out.print(number + " - " + i + "\n");
            }
        }
    }
}
