package org.example._2024_06_17.mockTask;

/**
 * Класс Student
 * Описание: Этот класс представляет студента.
 * Поля:
 * String id: уникальный идентификатор студента.
 * String name: имя студента.
 * Конструктор:
 * Принимает id и name.
 * Методы:
 * Геттеры для полей id и name.
 */
public record Student(
        String id,
        String name
) {

}