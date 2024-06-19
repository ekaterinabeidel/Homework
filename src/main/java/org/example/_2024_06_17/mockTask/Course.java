package org.example._2024_06_17.mockTask;

/**
 * Класс Course
 * Описание: Этот класс представляет курс.
 * Поля:
 * String id: уникальный идентификатор курса.
 * String name: название курса.
 * Конструктор:
 * Принимает id и name.
 * Методы:
 * Геттеры для полей id и name.
 */
public record Course(
        String id,
        String name
) {

}