package com.epam.task30;

import java.util.Random;
import java.util.Scanner;

/* 4.  Сортировка  обменами.  Дана  последовательность  чисел a1 <= a2 <= ... <= an. Требуется  переставить  числа  в
       порядке  возрастания.  Для  этого  сравниваются  два  соседних  числа a(i) и a(i + 1). Если a(i) > a(i + 1), то делается
       перестановка. Так продолжается до тех пор, пока все элементы не станут расположены в порядке возрастания.
       Составить алгоритм сортировки, подсчитывая при этом количества перестановок. */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random random = new Random();

        System.out.print("size: ");
        int size = in.nextInt();

        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(21) - 10;
            System.out.print(array[i] + "\t");
        }

        int temp;
        int count = 0;
        boolean flag = true;

        while (flag) {
            flag = false;
            for (int i = 0; i < size - 1; i++) {
                if (array[i] > array[i + 1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    count++;
                    flag = true;
                }
            }
        }

        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println("\nКоличество перестановок: " + count);
    }
}
