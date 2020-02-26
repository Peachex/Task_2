package com.epam.task41;

// 7. Написать метод(методы) для вычисления суммы факториалов всех нечетных чисел от 1 до 9.
public class Main {
    public static void main(String[] args) {
        System.out.println("Сумма факториалов всех нечетных чисел от 1 до 9 = " + findSum());
    }

    public static int findSum() {
        int sumFact = 0;
        int fact = 1;

        for (int i = 1; i < 10; i++) {
            fact *= i;
            if (i % 2 != 0) {
                sumFact += fact;
            }
        }

        return sumFact;
    }
}