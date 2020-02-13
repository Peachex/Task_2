package com.epam.task38;

import java.util.Scanner;

/* 4. На плоскости заданы своими координатами n точек. Написать метод(методы), определяющие, между какими
   из пар точек самое большое расстояние. Указание. Координаты точек занести в массив. */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Количество точек: ");
        int size = in.nextInt();

        double[] arrayX = new double[size];
        double[] arrayY = new double[size];

        for (int i = 0; i < size; i++) {
            System.out.print("Введите x" + (i + 1) + " и y" + (i + 1) + ": ");
            arrayX[i] = in.nextDouble();
            arrayY[i] = in.nextDouble();
        }

        System.out.println("\nТочки: ");

        char l = 'A';
        for (int i = 0; i < size; i++) {
            System.out.print(l + "(" + arrayX[i] + "; " + arrayY[i] + ")\t\t");
            l++;
        }

        findMaxLength(arrayX, arrayY, size);
    }

    public static double length(double x1, double y1, double x2, double y2) {
        return (Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)));
    }

    public static void findMaxLength(double[] arrayX, double[] arrayY, int size) {
        double maxLength = 0;

        int maxIndex1 = 0;
        int maxIndex2 = 0;

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (length(arrayX[i], arrayY[i], arrayX[j], arrayY[j]) > maxLength) {
                    maxLength = length(arrayX[i], arrayY[i], arrayX[j], arrayY[j]);
                    maxIndex1 = i;
                    maxIndex2 = j;
                }
            }
        }

        char l1 = 65;
        char l2 = 65;

        l1 += maxIndex1;
        l2 += maxIndex2;

        System.out.println("\n\nМаксимальным расстоянием будет прямая " + l1 + l2 + ".\nРасстояние = " + maxLength);
    }
}
