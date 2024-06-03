package org.example._2024_05_22.taski5;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Метод flatMap позволяет более гибко работать с
 * вложенными структурами данных и преобразовывать элементы
 * потока в другие потоки. Он часто применяется для разложения
 * и объединения данных, создания комбинаций и фильтрации значений.
 */
public class FlatMapExamples {
    public static void main(String[] args) {
//        // Примеры использования flatMap
//
//        // Простой пример: преобразование символов строки в отдельные элементы потока
//        /**
//         * Простой пример: у нас есть список строк words, и мы хотим
//         * преобразовать каждую строку в отдельные символы. Мы используем flatMap,
//         * чтобы преобразовать каждую строку в поток символов, используя split(""),
//         * и затем собираем символы обратно в список characters.
//         * Результат: Characters: [H, e, l, l, o, W, o, r, l, d].
//         */
        List<String> words = Arrays.asList("Hello", "World");
        List<Character> characters = words.stream()
                .flatMap(s -> s.chars().mapToObj(c -> (char) c))
                .collect(Collectors.toList());
        System.out.println("Characters: " + characters);

//        // Средний пример: преобразование элементов списка в поток и фильтрация значений
        /**
         * Средний пример: у нас есть список списков numbers,
         * и мы хотим получить все четные числа из этих списков.
         * Мы используем flatMap, чтобы преобразовать каждый внутренний
         * список в поток чисел, а затем фильтруем только четные числа.
         * Результат: Even numbers: [2, 4, 6].
         */
        List<List<Integer>> numbers = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, 4),
                Arrays.asList(5, 6)
        );
        List<Integer> evenNumbers = numbers.stream()
                .flatMap(Collection::stream)
                .filter(num -> num % 2 == 0)
                        .toList();
        System.out.println("Even numbers: " + evenNumbers);

        // Сложный пример: преобразование элементов списка в пары и их комбинирование
        /**
         * Сложный пример: у нас есть два списка list1 и list2, и мы
         * хотим получить все возможные комбинации сумм чисел из обоих списков.
         * Мы используем flatMap, чтобы преобразовать каждый элемент из list1 в поток,
         * затем применяем map, чтобы создать поток сумм чисел из list1 и list2,
         * и наконец, собираем все значения в combinedList.
         * Результат: Combined list: [5, 6, 7, 6, 7, 8, 7, 8, 9].
         */
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(4, 5, 6);
        List<Integer> combinedList = list1.stream()
                .flatMap(num1 -> list2.stream().map(num2 -> num1 + num2))
                .collect(Collectors.toList());
        System.out.println(STR."Combined list: \{combinedList}");
    }
}