package com.epam.task26;

import java.util.Random;
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
        Random random = new Random();

        System.out.print("size: ");
        int size = in.nextInt();

        int[][] matrix = new int[size][size];
        zeroMatrix(matrix, size);

        if (size % 2 != 0) {
            int number = 1;
            magicSquare(matrix, size, number);

        } else {
            if (size % 2 == 0 && size % 4 != 0) {
                int size2 = size / 2;

                int[][] matrix1 = new int[size2][size2];
                zeroMatrix(matrix1, size2);

                int number = 1;
                magicSquare(matrix1, size2, number);

                int[][] matrix2 = new int[size2][size2];
                zeroMatrix(matrix2, size2);

                magicSquare(matrix2, size2, number);

                int[][] matrix3 = new int[size2][size2];
                zeroMatrix(matrix3, size2);

                magicSquare(matrix3, size2, number);

                int[][] matrix4 = new int[size2][size2];
                zeroMatrix(matrix4, size2);

                magicSquare(matrix4, size2, number);

                for (int i = 0; i < size2; i++) {
                    for (int j = 0; j < size2; j++) {
                        matrix[i][j] = matrix1[i][j];
                    }
                }

                for (int i = 0; i < size2; i++) {
                    for (int j = 0; j < size2; j++) {
                        matrix[i + size2][j + size2] = matrix2[i][j];
                    }
                }

                for (int i = 0; i < size2; i++) {
                    for (int j = 0; j < size2; j++) {
                        matrix[i][j + size2] = matrix3[i][j];
                    }
                }

                for (int i = 0; i < size2; i++) {
                    for (int j = 0; j < size2; j++) {
                        matrix[i + size2][j] = matrix4[i][j];
                    }
                }

                int[][] matrix0 = new int[size][size];
                int p = size2 * size2;
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        if (i < size2 && j < size2) {
                            matrix0[i][j] = 0;
                        } else {
                            if (i < size2 && j >= size2) {
                                matrix0[i][j] = 2 * p;
                            } else {
                                if (i >= size2 && j < size2) {
                                    matrix0[i][j] = 3 * p;
                                } else {
                                    if (i >= size2 && j >= size2) {
                                        matrix0[i][j] = p;
                                    }
                                }
                            }
                        }
                    }
                }

                int k = (size - 2) / 4;
                int temp;
                for (int i = 0; i < size2; i++) {
                    for (int j = 0; j < size2; j++) {
                        if (i != (size2 - 1) / 2) {
                            if (j < k) {
                                temp = matrix0[i][j];
                                matrix0[i][j] = matrix0[i + size2][j];
                                matrix0[i + size2][j] = temp;
                            }
                        } else {
                            if (j <= (size2 - 1) / 2 && j >= ((size2 - 1) / 2) - (k - 1)) {
                                temp = matrix0[i][j];
                                matrix0[i][j] = matrix0[i + size2][j];
                                matrix0[i + size2][j] = temp;
                            }
                        }
                    }
                }

                for (int i = 0; i < size2; i++) {
                    for (int j = size - 1; j > size - k; j--) {
                        temp = matrix0[i][j];
                        matrix0[i][j] = matrix0[i + size2][j];
                        matrix0[i + size2][j] = temp;
                    }
                }

                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        matrix[i][j] += matrix0[i][j];
                    }
                }
            } else {
                if (size % 2 == 0 && size % 4 == 0) {
                    int number1 = 0;
                    int number2 = size * size + 1;
                    for (int i = 0; i < size; i++) {
                        for (int j = 0; j < size; j++) {
                            number1++;
                            number2--;
                            if ((i < size / 4 || i > size - size / 4 - 1) && (j < size / 4 || j > size - size / 4 - 1)) {
                                matrix[i][j] = number1;
                            } else {
                                if ((i >= size / 4 && i <= size - size / 4 - 1) && (j >= size / 4 && j < size - size / 4)) {
                                    matrix[i][j] = number1;
                                } else {
                                    matrix[i][j] = number2;
                                }
                            }
                        }
                    }
                }
            }
        }

        viewMatrix(matrix, size);
        System.out.println("This square is magic square: " + checkMagicSquare(matrix, size));
    }

    public static void magicSquare(int[][] matrix, int size, int number) {
        int i = 0;
        int j = (size + 1) / 2 - 1;
        matrix[i][j] = number;
        number++;
        i--;
        j++;

        for (int count = 0; count < size * size - 1; count++, i--, j++, number++) {
            if (i < 0 && j > size - 1) {
                i += 2;
                j -= 1;
                matrix[i][j] = number;
            } else {
                if (i < 0) {
                    i = size - 1;
                    matrix[i][j] = number;
                } else {
                    if (j > size - 1) {
                        j = 0;
                        matrix[i][j] = number;
                    } else {
                        if (matrix[i][j] != 0) {
                            i += 2;
                            j -= 1;
                            matrix[i][j] = number;
                        } else {
                            matrix[i][j] = number;
                        }
                    }
                }
            }
        }
    }

    public static void zeroMatrix(int[][] matrix, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = 0;
            }
        }
    }

    public static void viewMatrix(int[][] matrix, int size) {
        for (int a = 0; a < size; a++) {
            for (int b = 0; b < size; b++) {
                System.out.print(matrix[a][b] + "\t\t");
            }
            System.out.println();
        }
        System.out.println();
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
/* Алгоритмы, по которым строился магический квадрат были взяты с сайтов:
  1) https://ru.m.wikihow.com/%D1%80%D0%B5%D1%88%D0%B8%D1%82%D1%8C-%D0%BC%D0%B0%D0%B3%D0%B8%D1%87%D0%B5%D1%81%D0%BA%D0%B8%D0%B9-%D0%BA%D0%B2%D0%B0%D0%B4%D1%80%D0%B0%D1%82#.D0.A1.D0.BE.D0.B2.D0.B5.D1.82.D1.8B
  2) http://www.natalimak1.narod.ru/metody6.htm
*/