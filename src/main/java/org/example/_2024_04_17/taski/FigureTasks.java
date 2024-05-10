package org.example._2024_04_17.taski;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FigureTasks {

    // ****************** Basic Tasks ******************

    /**
     * 1. Напишите метод для подсчета всех кругов заданного цвета в списке фигур.
     */
    public static int countCirclesOfColor(List<Figure> figures, Color color) {
        int circleCount = 0; // Инициализируем счетчик кругов
        // Проходим по каждой фигуре в списке
        for (Figure figure : figures) {
            // Проверяем, является ли фигура кругом и имеет ли она указанный цвет
            if (figure instanceof Circle && figure.getColor() == color) {
                circleCount++; // Увеличиваем счетчик, если фигура удовлетворяет условиям
            }
        }
        return circleCount; // Возвращаем количество найденных кругов заданного цвета
    }


    /**
     * 2. Напишите метод для нахождения прямоугольника с максимальной площадью.
     */
    /*
     * Для решения этой задачи нам нужно пройти по списку фигур и найти прямоугольник с максимальной площадью.
     */
    public static Rectangle findRectangleWithMaxArea(List<Figure> figures) {
        Rectangle maxAreaRectangle = null; // Переменная для хранения прямоугольника с максимальной площадью
        double maxArea = Double.MIN_VALUE; // Переменная для хранения максимальной площади

        // Проходим по каждой фигуре в списке
        for (Figure figure : figures) {
            if (figure instanceof Rectangle) { // Проверяем, является ли фигура прямоугольником
                Rectangle rectangle = (Rectangle) figure; // Приводим фигуру к типу Rectangle
                double area = rectangle.getA() * rectangle.getB(); // Вычисляем площадь прямоугольника
                if (area > maxArea) {
                    // Если площадь текущего прямоугольника больше максимальной площади,
                    // обновляем прямоугольник с максимальной площадью и максимальную площадь
                    maxAreaRectangle = rectangle;
                    maxArea = area;
                }
            }
        }

        return maxAreaRectangle; // Возвращаем прямоугольник с максимальной площадью


    }

    /**
     * 3. Напишите метод для вывода всех треугольников, у которых все стороны равны.
     */
    public static void printEquilateralTriangles(List<Figure> figures) {
        // Проходим по каждой фигуре в списке
        for (Figure figure : figures) {
            // Проверяем, является ли фигура треугольником
            if (figure instanceof Triangle) {
                Triangle triangle = (Triangle) figure; // Приводим фигуру к типу Triangle
                // Проверяем, равны ли все стороны треугольника
                if (triangle.getA() == triangle.getB() && triangle.getB() == triangle.getC()) {
                    // Если стороны равны, выводим информацию о треугольнике в консоль
                    System.out.println(triangle);
                }
            }
        }
    }

    /**
     * 4. Напишите метод для нахождения суммы радиусов всех кругов определенного цвета.
     */
    /*
    * Для решения этой задачи нам нужно пройти по списку фигур,
    * и для каждой фигуры, являющейся кругом и имеющей указанный цвет, сложить радиусы этих кругов.
    * Создать переменную для хранения суммы радиусов и инициализировать ее значением 0.
    * Пройти по списку фигур.
    * Для каждой фигуры, если она является кругом и имеет указанный цвет, добавить ее радиус к общей сумме.
    * По завершении прохода по списку, вернуть сумму радиусов.
    */
    public static int sumOfRadiiForColor(List<Figure> figures, Color color) {
        int sumOfRadii = 0; // Переменная для хранения суммы радиусов

        // Проходим по каждой фигуре в списке
        for (Figure figure : figures) {
            // Проверяем, является ли фигура кругом и имеет ли указанный цвет
            if (figure instanceof Circle && figure.getColor() == color) {
                Circle circle = (Circle) figure; // Приводим фигуру к типу Circle
                sumOfRadii += circle.getRadius(); // Добавляем радиус к общей сумме
            }
        }

        return sumOfRadii; // Возвращаем сумму радиусов
    }

    /**
     * 5. Напишите метод для определения, есть ли в списке фигур прямоугольник и треугольник одинакового цвета.
     */
    public static boolean hasRectangleAndTriangleOfSameColor(List<Figure> figures) {
        // Проходим по каждой фигуре в списке
        for (int i = 0; i < figures.size() - 1; i++) {
            for (int j = i + 1; j < figures.size(); j++) {
                // Проверяем, является ли фигура с индексом i прямоугольником
                if (figures.get(i) instanceof Rectangle) {
                    // Проверяем, является ли фигура с индексом j треугольником и имеет ли тот же цвет
                    if (figures.get(j) instanceof Triangle && figures.get(i).getColor() == figures.get(j).getColor()) {
                        return true; // Если условие выполняется, возвращаем true
                    }
                }
                // Проверяем, является ли фигура с индексом i треугольником
                else if (figures.get(i) instanceof Triangle) {
                    // Проверяем, является ли фигура с индексом j прямоугольником и имеет ли тот же цвет
                    if (figures.get(j) instanceof Rectangle && figures.get(i).getColor() == figures.get(j).getColor()) {
                        return true; // Если условие выполняется, возвращаем true
                    }
                }
            }
        }
        // Если дошли до этой точки, значит, в списке нет прямоугольника и треугольника одинакового цвета
        return false;
    }

    // ****************** Intermediate Tasks ******************

    /**
     * 6. Напишите метод для нахождения круга с минимальным радиусом среди кругов заданного цвета.
     */
    public static Circle findCircleWithMinRadiusOfColor(List<Figure> figures, Color color) {
        return null;
    }

    /**
     * 7. Напишите метод для подсчета треугольников, у которых хотя бы одна сторона больше заданного значения.
     */
    public static int countTrianglesWithSideGreaterThan(List<Figure> figures, int length) {
        return 0;
    }

    /**
     * 8. Напишите метод для нахождения всех кругов, у которых радиус равен любой из сторон любого треугольника.
     */
    public static List<Circle> findCirclesWithRadiusEqualToTriangleSide(List<Figure> figures) {

        return null;
    }

    // ****************** Upper Intermediate Tasks ******************

    /**
     * 9. Напишите метод для нахождения треугольника, у которого разница между
     * максимальной и минимальной сторонами минимальна среди всех треугольников.
     */
    public static Triangle findTriangleWithSmallestSideDifference(List<Figure> figures) {
        return null;
    }

    /**
     * 10. Напишите метод для вывода всех фигур, у которых хотя бы один параметр
     * (цвет, радиус, сторона) совпадает с аналогичным параметром другой фигуры.
     */
    public static void printFiguresWithAtLeastOneMatchingParameter(List<Figure> figures) {
    }

    // Helper method to determine if two figures have at least one matching parameter
    private static boolean figuresMatch(Figure a, Figure b) {
        return false;
    }

    /**
     * 11. Напишите метод для нахождения кругов, у которых радиус больше суммы сторон любого треугольника в списке.
     */
    public static List<Circle> findCirclesWithRadiusGreaterThanSumOfAnyTriangleSides(List<Figure> figures) {

        return null;
    }

    // ****************** Advanced Tasks ******************

    /**
     * 12. Напишите метод для нахождения круга, который можно вписать в
     * наибольшее количество треугольников, учитывая их углы и стороны.
     */
    public static Circle findCircleThatFitsMostTriangles(List<Figure> figures) {
        return null;
    }


    /**
     * 13. Напишите метод для определения треугольника с наименьшим углом, вписывающимся в заданный круг.
     */
    public static Triangle findSmallestAngleTriangleInCircle(Circle circle, List<Figure> figures) {
        return null;
    }

    // ****************** Expert Tasks ******************

    /**
     * 14. Напишите метод для определения круга,
     * у которого соотношение площади к радиусу является наименьшим среди всех кругов.
     */
    public static Circle findCircleWithSmallestAreaToRadiusRatio(List<Figure> figures) {
        return null;
    }

    /**
     * 15. Напишите метод для определения, можно ли составить
     * из треугольников полигон без промежутков и наружных выступов.
     */
    public static boolean canFormClosedPolygonFromTriangles(List<Figure> figures) {
        return true;
    }

    /**
     * 16. Напишите метод для определения прямоугольника с наибольшим отношением диагонали к периметру.
     */
    public static Rectangle findRectangleWithLargestDiagonalToPerimeterRatio(List<Figure> figures) {
        return null;
    }

    /**
     * 17. Напишите метод для нахождения всех комбинаций фигур,
     * которые могут быть соединены таким образом, чтобы их общая площадь была равна заданному значению.
     */
    public static List<List<Figure>> findFigureCombinationsMatchingArea(List<Figure> figures, int targetArea) {
        return null;
    }
}