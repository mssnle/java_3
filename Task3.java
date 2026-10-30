package pract3;

import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размер массива N: ");
        int n = scanner.nextInt();

        int[] a = new int[n];
        System.out.println("Введите " + n + " целых чисел для массива A:");
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int[] b = transformArray(a);

        System.out.println("\nМассив A: " + transformArray(a));
        System.out.println("Массив B: " + transformArray(b));

        scanner.close();
    }

    public static int[] transformArray(int[] a) {
        int[] b = new int[a.length];

        for (int k = 0; k < a.length; k++) {
            if (a[k] > 10) {
                b[k] = a[k] % 10;
            } else {
                b[k] = a[k] + 9;
            }
        }

        return b;
    }
}
