package com.epam.task26;

import java.util.Scanner;

/* 16. Магическим квадратом порядка n называется квадратная матрица размера nxn, составленная из чисел 1, 2, 3,
   ..., n ^ 2 так, что суммы по каждому столбцу, каждой строке и каждой из двух больших диагоналей равны между
собой. Построить такой квадрат. Пример магического квадрата порядка 3: 6 1 8
                                                                       7 5 3
                                                                       2 9 4
*/
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input size:");
        int size = in.nextInt();

        int[][] magicSquare = new int[size][size];
        if (size % 2 !=0 ) {
            magicSquare = createMagicSquareForEvenSize(size * 2, 1);
        } else {
            if (size % 4 != 0) {
                magicSquare = createMagicSquareForOddEvenSize(size);
            } else {
                magicSquare = createMagicSquareForOddOddSize(size);
            }
        }

        System.out.println("Is magic square: " + checkMagicSquare(magicSquare, size));
        for (int[] i : magicSquare) {
            for (int j : i) {
                System.out.print(j + "\t");
            }
            System.out.println();
        }
    }

    public static int[][] createMagicSquareForOddOddSize(int size) {
        int[][] magicSquare = new int[size][size];
        int count1 = size / 4;
        int number1 = 1;
        int number2 = (int) Math.pow(size, 2);
        for (int i = 0; i < magicSquare.length; i++) {
            for (int j = 0; j < magicSquare[i].length; j++) {
                if (((i < count1 || i > magicSquare.length - count1 - 1) && (j < count1 || j > magicSquare.length - 1 - count1))
                        || (i >= count1 && i <= magicSquare.length - count1 - 1) && (j >= count1 && j < magicSquare.length - count1)) {
                    magicSquare[i][j] = number1++;
                    number2--;
                } else {
                    magicSquare[i][j] = number2--;
                    number1++;
                }
            }
        }
        return magicSquare;
    }

    public static void removeMagicSquareElementsForOddEvenSize(int[][] matrix2) {
        int k = (matrix2.length - 2) / 4;
        for (int i = 0; i < matrix2.length / 2; i++) {
            if (i != matrix2.length / 2 / 2) {
                for (int j = 0; j < k; j++) {
                    int temp = matrix2[i][j];
                    matrix2[i][j] = matrix2[matrix2.length / 2 + i][j];
                    matrix2[matrix2.length / 2 + i][j] = temp;
                }
            } else {
                for (int j = matrix2.length / 2 / 2; j >= matrix2.length / 2 / 2 - (k - 1); j--) {
                    int temp = matrix2[i][j];
                    matrix2[i][j] = matrix2[matrix2.length - (i + 1)][j];
                    matrix2[matrix2.length - (i + 1)][j] = temp;
                }
            }
        }
        for (int i = 0; i < matrix2.length / 2; i++) {
            for (int j = matrix2.length - 1; j >= matrix2.length - (k - 1); j--) {
                int temp = matrix2[i][j];
                matrix2[i][j] = matrix2[matrix2.length / 2 + i][j];
                matrix2[matrix2.length / 2 + i][j] = temp;
            }
        }
    }

    public static int[][] createMagicSquareForOddEvenSize(int size) {
        int[][] magicSquare = new int[size][size];
        fillMagicSquareForOddEvenSize(0, 0, size / 2, size / 2, createMagicSquareForEvenSize(size, 1), magicSquare);
        fillMagicSquareForOddEvenSize(0, size / 2, size / 2, size, createMagicSquareForEvenSize(size, (int) Math.pow(size, 2) / 2 + 1), magicSquare);
        fillMagicSquareForOddEvenSize(size / 2, 0, size, size / 2, createMagicSquareForEvenSize(size, 1 + (int) Math.pow(size, 2) - (int) Math.pow(size, 2) / 4), magicSquare);
        fillMagicSquareForOddEvenSize(size / 2, size / 2, size, size, createMagicSquareForEvenSize(size, (int) Math.pow(size, 2) / 4 + 1), magicSquare);
        removeMagicSquareElementsForOddEvenSize(magicSquare);
        return magicSquare;
    }

    public static void fillMagicSquareForOddEvenSize(int startI, int startJ, int endI, int endJ, int[][] magicSquare,
                                                     int[][] firstMatrix) {
        int countI = 0;
        int countJ;
        for (int i = startI; i < endI; i++, countI++) {
            countJ = 0;
            for (int j = startJ; j < endJ; j++, countJ++) {
                firstMatrix[i][j] = magicSquare[countI][countJ];
            }
        }
    }
    public static int[][] createMagicSquareForEvenSize(int size, int number) {
        size /= 2;
        int[][] magicSquare = new int[size][size];
        int rightPlaceI = 0;
        int rightPlaceJ = size / 2;
        int previousPlaceI;
        int previousPlaceJ;
        int count = 1;
        magicSquare[0][size / 2] = number++;
        while (count < (int) Math.pow(size, 2)) {
            previousPlaceI = rightPlaceI;
            previousPlaceJ = rightPlaceJ;
            rightPlaceI--;
            rightPlaceJ++;
            if (rightPlaceI < 0) {
                rightPlaceI = size - 1;
            }
            if (rightPlaceJ >= size) {
                rightPlaceJ = 0;
            }
            if (magicSquare[rightPlaceI][rightPlaceJ] != 0) {
                rightPlaceI = ++previousPlaceI;
                rightPlaceJ = previousPlaceJ;
            }
            magicSquare[rightPlaceI][rightPlaceJ] = number++;
            count++;
        }
        return magicSquare;
    }

    public static boolean checkMagicSquare(int[][] matrix, int size) {
        int sum1;
        int sum2;
        int magicConst = size * (size * size + 1) / 2;
        for (int i = 0; i < size; i++) {
            sum1 = sum2 = 0;
            for (int j = 0; j < size; j++) {
                sum1 += matrix[i][j];
                sum2 += matrix[j][i];
            }
            if (sum1 != magicConst || sum2 != magicConst) {
                return false;
            }
        }

        int sum3 = 0;
        int sum4 = 0;
        for (int i = 0; i < size; i++) {
            sum3 += matrix[i][i];
            sum4 += matrix[i][size - i - 1];
        }
        if (sum3 != magicConst && sum4 != magicConst) {
            return false;
        }

        return true;
    }
}
/*
  Алгоритмы, по которым строился магический квадрат были взяты с сайта: https://ru.m.wikihow.com/%D1%80%D0%B5%D1%88%D0%B8%D1%82%D1%8C-%D0%BC%D0%B0%D0%B3%D0%B8%D1%87%D0%B5%D1%81%D0%BA%D0%B8%D0%B9-%D0%BA%D0%B2%D0%B0%D0%B4%D1%80%D0%B0%D1%82#.D0.A1.D0.BE.D0.B2.D0.B5.D1.82.D1.8B
*/