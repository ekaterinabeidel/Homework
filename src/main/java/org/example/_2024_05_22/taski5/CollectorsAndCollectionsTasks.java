package org.example._2024_05_22.taski5;

import org.example._2024_05_22.taski1.Person;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CollectorsAndCollectionsTasks {

    public static void main(String[] args) {
        // Задача 1: Собрать элементы потока в список.
        List<String> task1 = Stream.of("A", "B", "C")
                        .toList();
        System.out.println("Task 1: " + task1);

        // Задача 2: Удалить дубликаты из списка и собрать их в множество.
        List<String> task2Input = Arrays.asList("A", "B", "A", "C");
        Set<String> task2 = new HashSet<>(task2Input);
        System.out.println("Task 2: " + task2);

        // Задача 3: Группировка строк по длине.
        List<String> words = Arrays.asList("apple", "banana", "cherry", "Apple", "Banana", "Cherry");
        Map<Integer, List<String>> task3 =  words.stream()
                        .collect(Collectors.groupingBy((String::length),Collectors.toList()));
        System.out.println("Task 3: " + task3);

        // Задача 4: Подсчет повторяющихся элементов и создание мапы.

        List<String> task4Input = Arrays.asList("A", "B", "A", "C", "B", "D");
        Map<String, Long> task4 = task4Input.stream()
                        .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        System.out.println("Task 4: " + task4);

        // Задача 5: Собрать только уникальные элементы в список.
        List<String> task5Input = Arrays.asList("A", "B", "A", "C", "B", "D");
        List<String> task5 = task5Input.stream().distinct().collect(Collectors.toList());
        System.out.println("Task 5: " + task5);

        // Задача 6: Максимальные длины.
        String task6 = words.stream()
                        .max((s1,s2)->Integer.compare(s1.length(), s2.length()))
                .orElse(null);
        System.out.println("Task 6: " + task6);

        // Задача 7: Разбиение строки на символы и сбор их в множество.
        String task7Input = "hello";
        Set<Character> task7 = task7Input.chars()
                        .mapToObj(c->(char) c)
                                .collect(Collectors.toSet());
        System.out.println("Task 7: " + task7);

        // Задача 8: Построение кастомной мапы из элементов.
        Map<String, Integer> task8 = words.stream()
                        .collect(Collectors.toMap(
                                word->word,
                                String::length
                        ));
        System.out.println("Task 8: " + task8);

        // Задача 9: Подсчет суммы значений объектов.
        List<Person> people = Arrays.asList(
                new Person("John", 20),
                new Person("Jane", 25),
                new Person("Jack", 30),
                new Person("James", 35),
                new Person("Jill", 40),
                new Person("Jill", 30),
                new Person("Jill", 20)
        );
        int totalAge = people.stream()
                        .flatMapToInt(person -> IntStream.of(person.getAge()))
                                .sum();
        System.out.println("Task 9: " + totalAge);
        // Задача 10: Группировка по критерию и подсчет среднего.
        Map<String, Double> task10Input = people.stream()
                        .collect(Collectors.groupingBy(Person::getName,Collectors.averagingInt(Person::getAge)));
        System.out.println("Task 10: " + task10Input);
    }

    static class Person {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }
}
