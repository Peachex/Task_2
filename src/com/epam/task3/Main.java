package com.epam.task3;

import java.util.Scanner;

/* 3.  Дан  массив  действительных  чисел,  размерность  которого  N.  Подсчитать,  сколько  в  нем  отрицательных,
положительных и нулевых элементов. */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("size: ");
        int size = in.nextInt();

        double[] array = new double[size];

        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * 50 + 1) - 25;
            System.out.print(array[i] + "  ");
        }

        int countPositive = 0;
        int countNegative = 0;
        for (int i = 0; i < size; i++) {
            if (array[i] > 0) {
                countPositive++;
            } else {
                if (array[i] < 0) {
                    countNegative++;
                }
            }
        }
        System.out.println("\nПоложительные числа: " + countPositive + "\nОтрицательные числа: " + countNegative + "\nЧисла, равные нулю: " + (size - countNegative - countPositive));
    }
}
