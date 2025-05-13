import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class FilterAndSortList {
    // Метод, який перевіряє чи число відповідає умовам задачі
    static boolean isValid(int num) {
        String s = String.valueOf(num); // перетворюємо число на рядок
        if (s.length() < 4) return false; // перевірка на мінімум 4 цифри

        // Отримуємо цифри по позиціях
        int last = Character.getNumericValue(s.charAt(s.length() - 1));        // остання цифра
        int secondLast = Character.getNumericValue(s.charAt(s.length() - 2)); // передостання цифра
        int first = Character.getNumericValue(s.charAt(0));                   // перша цифра
        int second = Character.getNumericValue(s.charAt(1));                 // друга цифра

        int sumLast = last + secondLast;   // сума останніх 2 цифр
        int sumFirst = first + second;     // сума перших 2 цифр

        // Перевірка умов: останні — парна сума, перші — непарна
        return (sumLast % 2 == 0) && (sumFirst % 2 != 0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // об'єкт для вводу з клавіатури
        Random rnd = new Random();           // об'єкт для генерації випадкових чисел

        System.out.print("Введіть розмір списку: ");
        int size = sc.nextInt(); // розмір списку, який задає користувач

        ArrayList<Integer> list = new ArrayList<>(); // створення порожнього списку

        // Заповнення списку випадковими числами, що відповідають умовам
        while (list.size() < size) {
            int num = 1000 + rnd.nextInt(9000); // генерація 4-значного числа (1000–9999)
            if (isValid(num)) { // перевірка відповідності умовам
                list.add(num);  // додавання числа до списку
            }
        }

        // Вивід списку до сортування
        System.out.println("Список до сортування:");
        System.out.println(list);

        // Сортування за трьома останніми цифрами з використанням компаратора
        Collections.sort(list, new Last3DigitsComparator());

        // Вивід списку після сортування
        System.out.println("Список після сортування за 3 останніми цифрами:");
        System.out.println(list);
    }
}