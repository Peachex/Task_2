package com.epam.task44;

import java.util.Scanner;

// 10. Дано натуральное число N. Написать метод(методы) для формирования массива, элементами которого являются цифры числа N.
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int number = in.nextInt();

        System.out.println("\n" + number);

        int length = 1;
        int size = 0;

        while (length <= number) {
            length *= 10;
            size++;
        }

        length /= 10;

        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = numeral(number, i, length);
            number -= array[i] * length / Math.pow(10, i);

            System.out.print(array[i] + "\t");
        }

        System.out.println();
    }

    public static int numeral(int number, int count, int length) {
        return (int) (number / (length / Math.pow(10, count)));
    }
}
