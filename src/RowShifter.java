// Клас потоку, який виконує циклічну перестановку елементів у одному рядку матриці
class RowShifter extends Thread {
    private int[] row;        // Масив (рядок матриці), який обробляється
    private int rowIndex;     // Номер рядка (для зручності виводу)

    // Конструктор, приймає рядок і його індекс
    public RowShifter(int[] row, int rowIndex) {
        this.row = row;
        this.rowIndex = rowIndex;
    }

    // Метод, який виконується при запуску потоку
    public void run() {
        // Зберігаємо копію початкового рядка (для виводу)
        int[] original = row.clone();

        // Циклічний зсув вправо: останній елемент стає першим
        int last = row[row.length - 1];
        for (int i = row.length - 1; i > 0; i--) {
            row[i] = row[i - 1];
        }
        row[0] = last;

        // Синхронізований блок, щоб уникнути накладання виводу
        synchronized(System.out) {
            System.out.print("Початковий стан рядка " + rowIndex + ": ");
            printRow(original);
            System.out.print("Результат потоку для рядка " + rowIndex + ": ");
            printRow(row);
            System.out.println(); // Розділення для зручності
        }
    }

    // Метод для виводу рядка
    private void printRow(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}