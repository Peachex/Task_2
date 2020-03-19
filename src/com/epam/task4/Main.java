package com.epam.task4;

import java.util.Random;
import java.util.Scanner;

// 4. Даны действительные числа а 1  ,а 2  ,..., а n  . Поменять местами наибольший и наименьший элементы.
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random random = new Random();

        System.out.print("size: ");
        int size = in.nextInt();

        double[] array = new double[size];

        for (int i = 0; i < size; i++) {
            array[i] = random.nextDouble() * 51 - 25;

            System.out.print(array[i] + "  ");
        }

        int maxIndex = findMax(array);
        int minIndex = findMin(array);
        double temp;

        System.out.println("\n\nmax = " + array[maxIndex] + "\nmin = " + array[minIndex] + "\n");

        temp = array[maxIndex];
        array[maxIndex] = array[minIndex];
        array[minIndex] = temp;

        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + "  ");
        }
        System.out.println();
    }

    public static int findMax(double[] array) {
        double maxElement = array[0];
        int maxPosition = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > maxElement) {
                maxElement = array[i];
                maxPosition = i;
            }
        }

        return maxPosition;
    }

    public static int findMin(double[] array) {
        double minElement = array[0];
        int minPosition = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] < minElement) {
                minElement = array[i];
                minPosition = i;
            }
        }

        return minPosition;
    }
}
