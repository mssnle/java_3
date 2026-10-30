package pract3;

import java.util.Scanner;

public class Task4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество строк M: ");
        int m = scanner.nextInt();
        System.out.print("Введите количество столбцов N: ");
        int n = scanner.nextInt();

        int[][] matrix = new int[m][n];
        System.out.println("Введите элементы матрицы (" + m + "x" + n + "):");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        System.out.println("\nИсходная матрица:");
        printMatrix(matrix);

        System.out.println("\nМатрица, выводимая \"змейкой\":");
        printMatrixSnake(matrix);

        scanner.close();
    }

    public static void printMatrixSnake(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < matrix[i].length; j++) {
                    System.out.print(matrix[i][j] + "\t");
                }
            } else {
                for (int j = matrix[i].length - 1; j >= 0; j--) {
                    System.out.print(matrix[i][j] + "\t");
                }
            }
            System.out.println();
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
