package org.example._2024_05_22.taski2;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//уровень 7
public class Taski2 {
    public static void main(String[] args) {
        List<String> strings = List.of("cat is, bad", "pet is wet",  "set is red");
        List<String> strings2 = List.of("mama", "child",  "ritm");
        List<String> strings3 = List.of("mama myla ramu", "child",  "ritm");

        System.out.println(uniqueSortedWords(strings));
        System.out.println(uniqueChars(strings2));
        System.out.println(longestString(strings3));
    }

    //Напишите метод, который принимает список чисел и возвращает сумму квадратов всех нечетных чисел в списке.
    public static int sumOfSquaresOfOddNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> (number % 2 != 0))
                .mapToInt(number-> number*number)
                .sum();
    }
    //Напишите метод, который принимает список строк и возвращает список уникальных слов,
    // отсортированных в лексикографическом порядке.
    public static List<String> uniqueSortedWords(List<String> strings) {
        return strings.stream()
                .flatMap(s -> Arrays.stream(s.split("\\W+")))
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }
    //Напишите метод, который принимает список объектов и возвращает новый список, содержащий
    // только объекты, у которых определенное поле имеет заданное значение.
    public static <T> List<T> filterByField(List<T> objects, String fieldName, Object value) throws NoSuchFieldException {
//    return objects.stream()
//            .map(el-> {
//                try {
//                    return el.getClass().getDeclaredField(fieldName);
//                } catch (NoSuchFieldException e) {
//                    throw new RuntimeException(e);
//                }
//            })
//            .filter(field -> )
        return objects.stream()
                .filter(obj -> {

                    Field field = null;
                    try {
                        field = obj.getClass().getDeclaredField(fieldName);
                    } catch (NoSuchFieldException e) {
                        throw new RuntimeException(e);
                    }
                    Object fieldValue = null;
                    try {
                        fieldValue = field.get(obj);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                    return value.equals(fieldValue);
                }).collect(Collectors.toList());

    }
    //Напишите метод, кото рый принимает список строк и возвращает список строк, содержащих
    // только уникальные символы (т.е. символы, которые не повторяются в строке).
    public static List<String> uniqueChars(List<String> strings) {
        return strings.stream()
                .filter(s -> (s.chars().distinct().count()==s.length()))
                .collect(Collectors.toList());
        }


    //Напишите метод, который принимает список строк и возвращает самую длинную строку в списке.
    public static String longestString(List<String> strings) {
       return strings.stream()
                .sorted((el1, el2) -> el2.length() - el1.length())
                .limit(1)
                .collect(Collectors.joining());
    }

    //Напишите метод, который принимает список объектов и
    // возвращает среднее значение заданного числового поля всех объектов в списке.
    public static <T> double averageFieldValue(List<T> objects, String fieldName) throws NoSuchFieldException {
       Field field = null;
        return objects.stream()
                .mapToDouble(object -> {
                    try {
                        return ((Number)field.get(object)).doubleValue();
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                })
                .average().orElse(0.0);

    }
}
@Getter
@AllArgsConstructor
class Person {
    String name;
    int age;
}
