package pract3;

import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размер массива N: ");
        int n = scanner.nextInt();

        int[] array = new int[n];
        System.out.println("Введите " + n + " целых чисел:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        printEvenNumbersReverse(array);

        scanner.close();
    }

    public static void printEvenNumbersReverse(int[] array) {
        int k = 0;

        System.out.println("\nЧётные числа в порядке убывания индексов:");

        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] % 2 == 0) {
                System.out.print(array[i] + " ");
                k++;
            }
        }

        System.out.println("\nКоличество чётных чисел K = " + k);
    }
}