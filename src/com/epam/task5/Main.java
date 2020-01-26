package com.epam.task5;

import java.util.Scanner;

// 5. Даны целые числа а(1)  ,а(2)  ,..., а(n)  . Вывести на печать только те числа, для которых а(i)  > i.
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("size: ");
        int size = in.nextInt();

        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * 50 + 1) - 25;
            System.out.print(array[i] + " ");
        }

        System.out.println();

        for (int i = 0; i < size; i++) {
            if (array[i] > i) {
                System.out.print(array[i] + " ");
            }
        }
    }
}
