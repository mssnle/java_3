package pract3;

import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размер массива N: ");
        int n = scanner.nextInt();

        int[] array = new int[n];
        System.out.println("Введите " + n + " целых чисел:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        int maxFrequency = findMaxFrequency(array);

        System.out.println("Максимальное количество одинаковых элементов: " + maxFrequency);

        scanner.close();
    }

    public static int findMaxFrequency(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int maxCount = 0;

        for (int i = 0; i < array.length; i++) {
            int currentCount = 1;

            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    currentCount++;
                }
            }

            if (currentCount > maxCount) {
                maxCount = currentCount;
            }
        }

        return maxCount;
    }
}
