import java.util.Comparator;

// Клас компаратора для порівняння чисел лише за ТРЬОМА останніми цифрами
class Last3DigitsComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer a, Integer b) {
        // Порівнюємо залишок від ділення на 1000, тобто три останні цифри
        return (a % 1000) - (b % 1000);
    }
}