package org.example._2024_05_22.taski5;

import java.util.*;
import java.util.stream.Collectors;

public class StreamTasks {
    public static void main(String[] args) {
        // Задача 1: Фильтрация чисел больше 5 и вывод в порядке убывания
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> result = numbers.stream()
                .filter(num -> num > 5)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println(result);

        // Задача 2: Преобразование строк в верхний регистр и удаление дубликатов
        List<String> words = Arrays.asList("apple", "banana", "cherry", "Apple", "Banana", "Cherry");
        List<String> result2 = words.stream()
                .map(s -> s.toUpperCase())
                .distinct().
                collect(Collectors.toList());
        System.out.println(result2);
        // Задача 3: Вывод квадратов чисел, удовлетворяющих условию: больше 8
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> result3 = nums.stream().map(num -> num * num)
                .filter(num -> num > 8)
                .collect(Collectors.toList());
        System.out.println(result3);

        // Задача 4: Подсчет суммы четных чисел
        List<Integer> values = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int result4 =
                values.stream()
                        .filter(num -> num % 2 == 0)
                        .mapToInt(num -> num)
                        .sum();
        System.out.println(result4);

        // Задача 5: Преобразование чисел в строки и объединение их с разделителем
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        String result5 = integers.stream()
                .map(num -> num.toString())
                .collect(Collectors.joining(", "));
        System.out.println(result5);

        // Задача 6: Поиск первого четного числа
        Optional<Integer> firstEven = values.stream()
                .filter(num -> num % 2 == 0)
                .findFirst();
        System.out.println("First Even: " + firstEven.orElse(null));

        // Задача 7: Проверка, все ли строки начинаются с буквы "A"
        boolean allStartsWithA = words.stream()
                .allMatch(w -> w.startsWith("A"));
        System.out.println("All Start With A: " + allStartsWithA);

        // Задача 8: Пропуск первых 3 чисел и сумма оставшихся
        int sumAfterSkip = values.stream()
                .skip(3)
                .mapToInt(num -> num)
                .sum();
        System.out.println("Sum After Skip: " + sumAfterSkip);

        // Задача 9: Выбор минимального и максимального числа
        Optional<Integer> minValue = numbers.stream().min(Integer::compareTo);
        Optional<Integer> maxValue = numbers.stream().max(Integer::compareTo);
        System.out.println("Min Value: " + minValue.orElse(null));
        System.out.println("Max Value: " + maxValue.orElse(null));

//        // Задача 10: Группировка слов по длине
        Map<Integer, List<String>> wordsByLength = words.stream()
                .collect(Collectors.groupingBy(
                        el -> el.length(), Collectors.toList()));
        System.out.println("Words By Length: " + wordsByLength);

//        // Задача 11: Подсчет среднего значения чисел
        OptionalDouble average = values.stream()
                .mapToDouble(num -> num)
                .average();
        System.out.println("Average: " + average.orElse(0));
//
//        // Задача 12: Поиск всех слов, содержащих букву "a"
        List<String> wordsWithA = words.stream()
                .filter(w -> w.contains("a"))
                .collect(Collectors.toList());
        System.out.println("Words with 'a': " + wordsWithA);

        // Задача 13: Преобразование чисел в квадрат и сортировка в обратном порядке
        List<Integer> sortedSquares = numbers.stream()
                .map(num -> num * num)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println("Sorted Squares: " + sortedSquares);

        // Задача 14: Преобразование чисел в двоичный формат и объединение в строку
        String binaryString = numbers.stream()
                .mapToInt(num -> num)
                .mapToObj(Integer::toBinaryString)
                .collect(Collectors.joining(", "));
        System.out.println("Binary String: " + binaryString);

        // Задача 15: Фильтрация чисел, кратных 3, и преобразование их в строки
        List<String> numbersDivisibleByThree = numbers.stream()
                .filter(num -> num % 3 == 0)
                .map(num->num.toString())
                                        .collect(Collectors.toList());
        System.out.println("Numbers Divisible by 3: " + numbersDivisibleByThree);
    }
}