package com.epam.task41;

// 7. Написать метод(методы) для вычисления суммы факториалов всех нечетных чисел от 1 до 9.
public class Main {
    public static void main(String[] args) {
        System.out.println("Сумма факториалов всех нечетных чисел от 1 до 9 = " + findSum());
    }

    public static double findSum() {
        double fact = 1;
        double sumFact = 0;
        for (int i = 1; i <= 9; i += 2) {
            for (int j = 1; j <= i; j++) {
                fact *= j;
                sumFact += fact;
            }
        }
        return sumFact;
    }
}
