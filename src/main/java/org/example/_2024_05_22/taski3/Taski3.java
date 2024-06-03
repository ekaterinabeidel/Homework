package org.example._2024_05_22.taski3;


import org.example._2024_05_22.taski1.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Taski3 {

    /**
     * Дан список строк. Необходимо найти количество строк, которые содержат
     * заданное подстроку. Решение с использованием Stream API:
     */
    private static void m1() {
        List<String> list = Arrays.asList("Java", "JavaScript", "Python", "Ruby");
        String substring = "av";
        long count = list.stream()
                .filter(s -> s.contains(substring))
                .count();


        System.out.println("Количество строк, содержащих подстроку '" + substring + "': " + count);
    }


    /**
     * Дан список целых чисел. Необходимо найти максимальный
     * элемент списка, который делится на заданное число без остатка.
     * Решение с использованием Stream API:
     */
    private static void m2() {
        List<Integer> list = Arrays.asList(10, 15, 20, 25, 30);
        int num = 5;
        Optional<Integer> max = list.stream()
                .filter(n -> n % num == 0)
                .max((n2, n1) -> n2 - n1);
    }


    /**
     * Дана коллекция объектов класса Person. Класс Person содержит поля name и age.
     * Необходимо найти средний возраст людей, чьи имена начинаются на заданную букву.
     * Решение с использованием Stream API:
     */
    private static void m3() {
        List<Person> people = Arrays.asList(
                new Person("John", 20),
                new Person("Jane", 25),
                new Person("Jack", 30),
                new Person("James", 35),
                new Person("Jill", 40)
        );
        double averageAge =
                people.stream()
                        .filter(person -> person.getName().startsWith("J"))
                        .mapToInt(person -> person.getAge())
                        .average().orElse(0.0);


    }

    /**
     * Дана коллекция строк. Необходимо найти все уникальные слова, которые содержатся в
     * этой коллекции строк, и вернуть их в виде списка. Решение с использованием Stream API:
     */
    private static void m4() {
        List<String> lines = Arrays.asList(
                "Java is a programming language.",
                "Java is widely used in enterprise applications.",
                "Python is gaining popularity as a data science tool.",
                "Python is a versatile programming language."
        );
        List<String> uniqueWords = lines.stream()
                .flatMap(s -> Arrays.stream(s.split("\\W")))
                .distinct()
                .toList();

    }
}
