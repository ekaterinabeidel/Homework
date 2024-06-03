package org.example._2024_05_22.start;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamTasks {

    // 1. filter()
    // Задача: Отфильтровать список чисел, оставив только четные.
    public List<Integer> filterEvenNumbers(List<Integer> numbers) {
        List<Integer> list = numbers.stream()
                .filter(number -> number % 2 == 0)
                .collect(Collectors.toList());
        return list;
    }

    // 2. filter()
    // Задача: Отфильтровать список строк, оставив только те, которые начинаются с буквы "A".
    public List<String> filterStringsStartingWithA(List<String> strings) {
        List<String> strings1 = strings
                .stream()
                .filter(element -> element.startsWith("A"))
                .collect(Collectors.toList());
        return strings1;
    }

    // 3. map()
    // Задача: Преобразовать список строк в список их длин.
    public List<Integer> mapToStringLengths(List<String> strings) {
        List<Integer> integerList = strings.stream()
                .map(el -> el.length())
                .collect(Collectors.toList());
        return integerList;
    }

    // 4. map()
    // Задача: Преобразовать список чисел в список их квадратов.
    public List<Integer> mapToSquares(List<Integer> numbers) {
        List<Integer> list = numbers.stream()
                .map(el -> (int) Math.pow(el, 2))
                .collect(Collectors.toList());
        return list;
    }

    //    // 5. distinct()
    // Задача: Удалить дубликаты из списка чисел.
    public List<Integer> distinctNumbers(List<Integer> numbers) {
        List<Integer> list = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        return list;
    }

    // 6. distinct()
    // Задача: Удалить дубликаты строк из списка.
    public List<String> distinctStrings(List<String> strings) {
        return strings.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    // 7. sorted()
    // Задача: Отсортировать список чисел по возрастанию.
    public List<Integer> sortNumbersAscending(List<Integer> numbers) {
        return numbers.stream().sorted().collect(Collectors.toList());
    }

    // 8. sorted()
    // Задача: Отсортировать список строк по алфавиту.
    public List<String> sortStringsAlphabetically(List<String> strings) {
        return strings.stream().sorted().collect(Collectors.toList());
    }

    // 9. limit()
    // Задача: Вернуть первые 5 элементов из списка чисел.
    public List<Integer> limitFirstFiveNumbers(List<Integer> numbers) {
        return numbers.stream().limit(5).collect(Collectors.toList());
    }

    // 10. limit()
    // Задача: Вернуть первые 3 строки из списка.
    public List<String> limitFirstThreeStrings(List<String> strings) {
        return strings.stream().limit(3).collect(Collectors.toList());
    }

    // 11. skip()
    // Задача: Пропустить первые 3 элемента списка чисел.
    public List<Integer> skipFirstThreeNumbers(List<Integer> numbers) {
        return numbers.stream().skip(3).collect(Collectors.toList());
    }

    // 12. skip()
    // Задача: Пропустить первые 2 строки из списка.
    public List<String> skipFirstTwoStrings(List<String> strings) {
        return strings.stream().skip(2).collect(Collectors.toList());
    }

    // 13. forEach()
    // Задача: Напечатать каждое число из списка.
    public void forEachPrintNumber(List<Integer> numbers) {
        numbers.stream().forEach(System.out::println);
    }

//    // 14. forEach()
//    // Задача: Напечатать каждую строку из списка.
//    public void forEachPrintString(List<String> strings) {
//        // решение
//    }

    // 15. allMatch()
    // Задача: Проверить, все ли числа в списке четные.
    public boolean allMatchEvenNumbers(List<Integer> numbers) {
        return numbers.stream().allMatch(number -> number % 2 == 0);
    }

    // 16. anyMatch()
    // Задача: Проверить, есть ли в списке хотя бы одно отрицательное число.
    public boolean anyMatchNegativeNumber(List<Integer> numbers) {
        return numbers.stream().anyMatch(el -> el < 0);
    }

    // 17. noneMatch()
    // Задача: Проверить, нет ли в списке нулевых значений.
    public boolean noneMatchZero(List<Integer> numbers) {
        return numbers.stream().noneMatch(el -> el != 0);
    }

    // 18. findFirst()
    // Задача: Найти первый элемент в списке строк.
    public Optional<String> findFirstString(List<String> strings) {
        return strings.stream().findFirst();
    }

    // 19. reduce()
    // Задача: Найти сумму всех чисел в списке.
    public int reduceSum(List<Integer> numbers) {
        return numbers.stream().reduce(10, (accumulator, currentEl) -> accumulator + currentEl);
    }

    // 20. collect()
    // Задача: Собрать все строки в список, которые начинаются с буквы "B".
    public List<String> collectStringsStartingWithB(List<String> strings) {
        return strings.stream().filter(s -> s.startsWith("B")).collect(Collectors.toList());
    }

    // 21. flatMap()
    // Задача: Преобразовать список списков чисел в один плоский список.
    public List<Integer> flatMapLists(List<List<Integer>> listOfLists) {
        return listOfLists.stream().flatMap(integers -> integers.stream()).collect(Collectors.toList());
    }

    // 22. count()
    // Задача: Посчитать количество строк в списке, которые длиннее 3 символов.
    public long countLongStrings(List<String> strings) {
        return strings.stream().filter(s -> s.length() > 3).count();
    }

    // 23. max()
    // Задача: Найти максимальное значение в списке чисел.
    public Optional<Integer> findMaxValue(List<Integer> numbers) {
        return numbers.stream()
                .max((num1, num2) -> num1 - num2);
    }

    // 24. min()
    // Задача: Найти минимальное значение в списке чисел.
    public Optional<Integer> findMinValue(List<Integer> numbers) {
        return  numbers.stream()
                .min((num1, num2) -> num2 - num1);
    }

    // 25. findAny()
    // Задача: Найти любой элемент в списке строк, начинающийся с буквы "C".
    public Optional<String> findAnyStringStartingWithC(List<String> strings) {
        return strings.stream()
                .filter(s -> s.startsWith("C"))
                .findAny();
    }

    // 26. toArray()
    // Задача: Преобразовать список строк в массив строк.
    public String[] toArrayStrings(List<String> strings) {

        return (String[]) strings.stream()
                .toArray();
    }

    // 27. peek()
    // Задача: Вывести на экран каждое число из списка перед удвоением значения.
    public List<Integer> peekAndDoubleNumbers(List<Integer> numbers) {
        return numbers.stream()
                .peek(el -> System.out.println(el))
                .map(el -> el * el)
                .collect(Collectors.toList());

    }

    // 28. mapToInt()
    // Задача: Преобразовать список строк в список их длин и найти сумму длин всех строк.
    public int mapToIntAndSum(List<String> strings) {
        return strings.stream()
                .mapToInt(s -> s.length())
                .sum();

    }

}
