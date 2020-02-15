package com.epam.task46;

import java.util.Scanner;

/* 12. Даны натуральные числа К и N. Написать метод(методы) формирования массива А, элементами которого
   являются числа, сумма цифр которых равна К и которые не большее N. */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("K, N: ");

        int k = in.nextInt();
        int n = in.nextInt();

        int size;
        size = (n - k) / 9 + 1;

        int[] array = new int[size];

        array[0] = k;
        System.out.print(array[0] + "\t");

        for (int i = 1; i < size; i++) {
            array[i] = arrayElement(array[i - 1]);
            System.out.print(array[i] + "\t");
        }
    }

    public static int arrayElement(int number) {
        return (number + 9);
    }
}

