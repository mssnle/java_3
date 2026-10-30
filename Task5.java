package pract3;

import java.util.Scanner;

public class Task5 {
    private static final double[] BMI_THRESHOLDS = {18.5, 25.0};
    private static final String[] BMI_CATEGORIES = {
            "недостаточный вес",
            "нормальный вес",
            "избыточный вес"
    };
    private static final double[] WEIGHT_LIMITS = {0.0, 250.0};
    private static final double[] HEIGHT_LIMITS = {0.0, 250.0};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            showMenu();
            int choice = readMenuChoice(scanner);

            switch (choice) {
                case 1:
                    runBmiScenario(scanner);
                    break;
                case 2:
                    showAboutProgram();
                    break;
                case 3:
                    isRunning = false;
                    System.out.println("\nСпасибо за использование программы!");
                    break;
            }
        }
        scanner.close();
    }

    public static void runBmiScenario(Scanner scanner) {
        System.out.println("\nРасчёт индекса массы тела (ИМТ)");
        double[] userData = readUserData(scanner);
        double[] result = calculateBmi(userData, BMI_THRESHOLDS);
        printBmiResult(result, BMI_CATEGORIES);
    }

    public static void showMenu() {
        System.out.println("\nГЛАВНОЕ МЕНЮ");
        System.out.println("1. Выполнить расчёт ИМТ");
        System.out.println("2. Информация о программе");
        System.out.println("3. Выход");
    }

    public static int readMenuChoice(Scanner scanner) {
        while (true) {
            System.out.print("Выберите пункт меню (1-3): ");
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                if (choice >= 1 && choice <= 3) {
                    return choice;
                } else {
                    System.out.println("Ошибка: введите число от 1 до 3.");
                }
            } else {
                System.out.println("Ошибка: необходимо ввести целое число");
                scanner.next();
            }
        }
    }

    public static double[] readUserData(Scanner scanner) {
        double[] data = new double[2];
        data[0] = readValidDouble(scanner, "Введите ваш вес в кг: ", WEIGHT_LIMITS);
        data[1] = readValidDouble(scanner, "Введите ваш рост в см: ", HEIGHT_LIMITS);
        return data;
    }

    public static double readValidDouble(Scanner scanner, String prompt, double[] limits) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                double value = scanner.nextDouble();
                if (value > limits[0] && value <= limits[1]) {
                    return value;
                } else {
                    System.out.printf("Ошибка: значение должно быть в диапазоне (%.1f; %.1f].\n",
                            limits[0], limits[1]);
                }
            } else {
                System.out.println("Ошибка: необходимо ввести число");
                scanner.next();
            }
        }
    }

    public static double[] calculateBmi(double[] userData, double[] thresholds) {
        double weight = userData[0];
        double heightMeters = userData[1] / 100.0;
        double bmi = weight / (heightMeters * heightMeters);

        int categoryIndex = thresholds.length;
        for (int i = 0; i < thresholds.length; i++) {
            if (bmi < thresholds[i]) {
                categoryIndex = i;
                break;
            }
        }

        return new double[]{bmi, categoryIndex};
    }

    public static void printBmiResult(double[] result, String[] categories) {
        double bmi = result[0];
        int index = (int) result[1];

        System.out.printf("\nВаш ИМТ: %.2f\n", bmi);
        System.out.println("Результат: У вас " + categories[index] + ".");
    }

    public static void showAboutProgram() {
        System.out.println("\nИнформация о программе");
        System.out.println("Это консольный калькулятор индекса массы тела (ИМТ).");
        System.out.println("Программа использует массивы для хранения параметров");
        System.out.println("и передачи данных между методами.");
    }
}