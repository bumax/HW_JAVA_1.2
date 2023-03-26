package exercises;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.*;

// 1.Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
public class Ex1 {
    public static void BubbleSort(int size) throws IOException {
        String s = "Debug the bubble sort algorithm";
        Logger logger = Logger.getLogger(s);
        logger.setUseParentHandlers(false); // отключаем вывод в консоль по умолчанию
        FileHandler fh = new FileHandler("log.txt");
        logger.addHandler(fh);
        fh.setFormatter(new SimpleFormatter()); // упрощенный текстовый формат

        int[] inArray = GetRandomArray(size);
        System.out.println("Исходный массив: " + PrintArray(inArray));
        logger.info("Origin: " + PrintArray(inArray)); // Выводим исходный массив
        int len = inArray.length;
        for (int i = 1; i < len; i++) {
            boolean isSorted = true; // Флаг отсортированного массива, взводим при каждой итерации
            for (int j = 0; j < len - i; j++) {
                if (inArray[j] > inArray[j + 1]) {
                    isSorted = false; // Сбрасываем флаг
                    int tmp = inArray[j + 1];
                    inArray[j + 1] = inArray[j];
                    inArray[j] = tmp;
                    logger.info(i +"." + j + ": "+ PrintArray(inArray)); // Выводим результат итерации
                }

            }
            if (isSorted) break;
        }
        System.out.println("Отсортированный массив: " + PrintArray(inArray));
    }

    private static String PrintArray(int[] array) {
        return String.join(",", Arrays.toString(array));
    }

    private static int[] GetRandomArray(int size) {
        int[] out = new int[size];
        for (int i = 0; i < size; i++) {
            out[i] = (int) (Math.random() * 100);
        }
        return out;
    }
}
