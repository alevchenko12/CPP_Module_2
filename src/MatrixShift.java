import java.util.ArrayList;
import java.util.Scanner;

// Головний клас програми
public class MatrixShift {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        // Ввід розмірів матриці
        System.out.print("Введіть кількість рядків: ");
        int rows = sc.nextInt();

        System.out.print("Введіть кількість стовпців: ");
        int cols = sc.nextInt();

        // Створення матриці
        int[][] matrix = new int[rows][cols];

        // Ввід елементів матриці по рядках
        System.out.println("Введіть елементи матриці по рядках:");
        for (int i = 0; i < rows; i++) {
            System.out.println("Рядок " + i + ":");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        // Список потоків
        ArrayList<RowShifter> threads = new ArrayList<>();

        // Створення та запуск потоку для кожного рядка
        for (int i = 0; i < rows; i++) {
            RowShifter t = new RowShifter(matrix[i], i); // створення потоку
            threads.add(t); // додавання до списку
            t.start(); // запуск потоку
        }

        // Очікуємо завершення всіх потоків
        for (RowShifter t : threads) {
            t.join(); // головний потік чекає завершення дочірніх
        }

        // Виведення фінального стану матриці після обробки
        System.out.println("Матриця після перестановок:");
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }

        sc.close(); // закриття сканера
    }
}
