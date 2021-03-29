package modul_5;

import java.util.Scanner;

/*
Задание 7
Заполните n-мерный квадратный массив возрастающими

числами – змейкой. Выведите результат на экран с соблюде-
нием ширины столбцов

Пример:

 1  2  3  4
 8  7  6  5
 9 10 11 12
16 15 14 13
 */
public class HW_3_7 {

    public static void printMatrix(int[][] matrix, int numLength){
        for (int[] line : matrix) {
            for (int el : line) {
                System.out.printf("%" + numLength + "d", el);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int arrayLength = input.nextInt();
        int numLength = String.valueOf(arrayLength * arrayLength).length() + 1;
        int[][] matrix = new int[arrayLength][arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            if (i % 2 == 0) {
                for (int j = 1; j <= arrayLength; j++) {
                    matrix[i][j - 1] = i * arrayLength + j;
                }
            } else {
                for (int j = arrayLength; j > 0; j--) {
                    matrix[i][j - 1] = i * arrayLength + arrayLength - j + 1;
                }
            }
        }

        printMatrix(matrix,numLength);
    }
}
