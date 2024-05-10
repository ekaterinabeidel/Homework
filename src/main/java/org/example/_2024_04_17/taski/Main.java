package org.example._2024_04_17.taski;

import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Figure> figures = FigureGenerator.generateFigures();
        Color color = Color.GREEN;
        System.out.println(figures);
        System.out.println("-------------------------------------------");
        int circleCount = FigureTasks.countCirclesOfColor(figures, color);
        System.out.println("Количество кругов цвета " + color + ": " + circleCount);
        System.out.println("-------------------------------------------");
        Rectangle maxAreaRectangle = FigureTasks.findRectangleWithMaxArea(figures);
        if (maxAreaRectangle != null) {
            System.out.println("Прямоугольник с максимальной площадью:");
            System.out.println(maxAreaRectangle);
        } else {
            System.out.println("В списке нет прямоугольников.");
        }
        System.out.println("-------------------------------------------");
        System.out.println("Треугольники с равными сторонами:");
        FigureTasks.printEquilateralTriangles(figures);
        System.out.println("-------------------------------------------");
        int sumOfRadii = FigureTasks.sumOfRadiiForColor(figures, color);
        System.out.println("Сумма радиусов кругов цвета " + color + ": " + sumOfRadii);
        System.out.println("-------------------------------------------");
        boolean hasSameColorRectangleAndTriangle = FigureTasks.hasRectangleAndTriangleOfSameColor(figures);
        if (hasSameColorRectangleAndTriangle) {
            System.out.println("В списке есть прямоугольник и треугольник одного цвета.");
        } else {
            System.out.println("В списке нет прямоугольника и треугольника одного цвета.");
        }
        System.out.println("------------MAP--countCirclesOfColor-------------------");
        Map<Color, Integer> colorCount = FigureTasksMap.countCirclesOfColor(figures);
        System.out.println(colorCount);
        System.out.println("--------MAP--Find the rectangle with the largest diagonal to perimeter ratio--------");
        Map<Rectangle, Double> rectangleRatios = FigureTasksMap.findRectangleWithLargestDiagonalToPerimeterRatio(figures);
        System.out.println(rectangleRatios);
        System.out.println("--------MAP--findCirclesWithRadiusEqualToTriangleSide--------");
        Map<Circle, Triangle> circleTriangleMap;
        circleTriangleMap = FigureTasksMap.findCirclesWithRadiusEqualToTriangleSide(figures);
        System.out.println(circleTriangleMap);
        System.out.println("--------MAP--hasRectangleAndTriangleOfSameColor--------");
        Map<String, Boolean> colorSame = FigureTasksMap.hasRectangleAndTriangleOfSameColor(figures);
        System.out.println(colorSame);


    }


}

class Figure {
    // Добавляем поле для хранения цвета
    private Color color;

    // Конструктор с цветом
    public Figure(Color color) {
        this.color = color;
    }

    // Геттер для цвета
    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return " " + color;
    }
}


@Getter
class Rectangle extends Figure {
    private int a;
    private int b;

    @Override
    public String toString() {
        return "Rectangle(" +
                "a=" + a +
                ", b=" + b
                + "," + super.toString() + ")";

    }

    public Rectangle(Color color, int a, int b) {
        super(color);
        this.a = a;
        this.b = b;
    }

    public double getDiagonal() {
        return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }

    public double getPerimeter() {
        return 2 * (a + b);
    }
}


@Getter
class Triangle extends Figure {
    private int a;
    private int b;
    private int c;

    @Override
    public String toString() {
        return "Triangle(" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c + "," +
                super.toString() + ")";
    }

    public Triangle(Color color, int a, int b, int c) {
        super(color);
        this.a = a;
        this.b = b;
        this.c = c;
    }
}


@Getter
class Circle extends Figure {
    private int radius;

    public Circle(Color color, int radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle(" +
                "radius = " + radius + "," +
                super.toString() +
                ")";
    }
}

@ToString
@Getter
enum Color {
    RED, BLACK, WHITE, BLUE, GREEN, YELLOW, ORANGE, PINK, PURPLE, MULTICOLOR
}
