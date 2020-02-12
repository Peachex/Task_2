package com.epam.task34;

import java.util.Random;
import java.util.Scanner;

/* Даны дроби p(1) / q(1), p(2) / q(2), ..., p(n) / q(n) (p(i), q(i) - натуральные). Составить программу, которая
   приводит эти дроби к общему знаменателю и упорядочивает их в порядке возрастания.  */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random random = new Random();

        System.out.print("количество дробей: ");
        int size = in.nextInt();

        int[] arrayUp = new int[size];
        int[] arrayDown = new int[size];

        for (int i = 0; i < size; i++) {
            arrayUp[i] = random.nextInt(6);
            arrayDown[i] = random.nextInt(10) + 1;
        }

        sort(arrayUp, arrayDown, size);

        int maxCommonDown = 1;
        for (int i = 0; i < size - 1; i++) {
            if (arrayDown[i] != arrayDown[i + 1]) {
                maxCommonDown *= arrayDown[i];
            }
        }
        maxCommonDown *= arrayDown[size - 1];

        int commonDown = 0;
        for (int number = arrayDown[size - 1]; number <= maxCommonDown; number++) {
            if (findCommonDown(arrayDown, size, number)) {
                commonDown = number;
                break;
            }
        }

        sort(arrayDown, arrayUp, size);

        System.out.println("Дроби: ");
        view(arrayUp, arrayDown, size);
        System.out.print("\nОбщий знаменатель = " + commonDown + "\n");

        for (int i = 0; i < size; i++) {
            arrayUp[i] *= commonDown / arrayDown[i];
            arrayDown[i] = commonDown;
        }

        System.out.println("Дроби c общим знаменателем: ");
        view(arrayUp, arrayDown, size);

        sort(arrayDown, arrayUp, size);

        System.out.println("\nДроби с общим знаменателем в порядке возрастания: ");
        view(arrayUp, arrayDown, size);
    }

    public static void view(int[] arrayUp, int[] arrayDown, int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(arrayUp[i] + "/" + arrayDown[i] + "\t\t");
        }
        System.out.println();
    }

    public static void sort(int[] arrayUp, int[] arrayDown, int size) {
        int temp;
        for (int count = 0; count < size - 1; count++) {
            for (int i = 0; i < size - 1; i++) {
                if (arrayDown[i] > arrayDown[i + 1]) {
                    temp = arrayDown[i];
                    arrayDown[i] = arrayDown[i + 1];
                    arrayDown[i + 1] = temp;

                    temp = arrayUp[i];
                    arrayUp[i] = arrayUp[i + 1];
                    arrayUp[i + 1] = temp;
                }
            }
        }
    }

    public static boolean findCommonDown(int[] arrayDown, int size, int number) {
        for (int i = 0; i < size; i++) {
            if (number % arrayDown[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
