package org.example._2024_04_17.taski;

import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@UtilityClass
public class FigureGenerator {
    /* Класс FigureGenerator объявлен с аннотацией @UtilityClass, что означает,
     * что он является утилитарным классом,
     * содержащим только статические методы, и не предполагает создания экземпляров.
     */


    private static final Random RANDOM = new Random();

    public static List<Figure> generateFigures() {
        /* Генерация списка фигур: Метод generateFigures генерирует и возвращает список из 100 случайных фигур.
         * Он создает новый пустой список figures, затем заполняет его,
         * вызывая метод generateRandomFigure 100 раз.
         */
        List<Figure> figures = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            figures.add(generateRandomFigure());
        }
        return figures;
    }

    private static Figure generateRandomFigure() {
        /* Случайная генерация фигур:
         * Метод generateRandomFigure случайным образом выбирает тип фигуры
         * (прямоугольник, треугольник или круг)
         * и вызывает соответствующий приватный метод для создания этой фигуры.
         */
        int figureType = RANDOM.nextInt(3);
        switch (figureType) {
            case 0:
                return generateRectangle();
            case 1:
                return generateTriangle();
            case 2:
                return generateCircle();
            default:
                throw new IllegalStateException("Unexpected value: " + figureType);
        }
    }
    /* Приватные методы для генерации фигур:
    * В этом классе есть три приватных метода (generateRectangle, generateTriangle и generateCircle),
    * которые генерируют случайные прямоугольники, треугольники и круги соответственно.
    * Каждый из этих методов выбирает случайный цвет и параметры фигуры и возвращает новый экземпляр
    * соответствующего класса.
    * */
    private static Rectangle generateRectangle() {
        Color color = Color.values()[RANDOM.nextInt(Color.values().length)];
        int a = 1 + RANDOM.nextInt(100);
        int b = 1 + RANDOM.nextInt(100);
        return new Rectangle(color, a, b);
    }

    private static Triangle generateTriangle() {
        Color color = Color.values()[RANDOM.nextInt(Color.values().length)];
        int a, b, c;
        do {
            a = 1 + RANDOM.nextInt(100);
            b = 1 + RANDOM.nextInt(100);
            c = 1 + RANDOM.nextInt(100);
        } while (!isValidTriangle(a, b, c));
        return new Triangle(color, a, b, c);
    }

    private static boolean isValidTriangle(int a, int b, int c) {
        return a + b > c && a + c > b && b + c > a;
    }

    private static Circle generateCircle() {
        Color color = Color.values()[RANDOM.nextInt(Color.values().length)];
        int radius = 1 + RANDOM.nextInt(50);
        return new Circle(color, radius);
    }
}