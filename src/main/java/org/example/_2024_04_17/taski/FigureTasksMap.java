package org.example._2024_04_17.taski;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FigureTasksMap {
    // ****************** Map ******************
    /* Для реализации метода countCirclesOfColor, который подсчитывает количество кругов заданного цвета в списке фигур, вам нужно выполнить следующие шаги:

     * Создать экземпляр Map<Color, Integer>, чтобы отслеживать количество кругов для каждого цвета.
     * Пройти по списку фигур.
     * Для каждой фигуры, которая является кругом, проверить его цвет и увеличить соответствующий счетчик в Map.
     * Вернуть Map, содержащий количество кругов каждого цвета.
     */


    public static Map<Color, Integer> countCirclesOfColor(List<Figure> figures) {
        Map<Color, Integer> colorCount = new HashMap<>();

        // Проходим по каждой фигуре в списке
        for (Figure figure : figures) {
            // Проверяем, является ли фигура кругом
            if (figure instanceof Circle) {
                Circle circle = (Circle) figure; // Приводим фигуру к типу Circle
                Color color = circle.getColor(); // Получаем цвет круга
                // Обновляем счетчик для данного цвета
                colorCount.put(color, colorCount.getOrDefault(color, 0) + 1);
            }
        }

        return colorCount;
    }

    //Find the rectangle with the largest diagonal to perimeter ratio:
    /*
     *   Найти прямоугольник с наибольшим отношением диагонали к периметру.
     *   Для реализации метода:
     *   Создадим пустую карту для хранения прямоугольников и соответствующих им отношений диагонали к периметру.
     *   Пройтись по списку фигур.
     *   Для каждой фигуры:
     *   Проверить, является ли она прямоугольником.
     *   Если да, вычислить отношение диагонали к периметру для этого прямоугольника.
     *   Добавить прямоугольник и его отношение в карту.
     *   Найти прямоугольник с наибольшим отношением диагонали к периметру.
     *   Вернуть найденный прямоугольник и его отношение в виде карты.
     */
    public static Map<Rectangle, Double> findRectangleWithLargestDiagonalToPerimeterRatio(List<Figure> figures) {
        Map<Rectangle, Double> rectangleRatios = new HashMap<>();
        // Создаем переменные для хранения информации о прямоугольнике с наибольшим отношением
        Rectangle maxRatioRectangle = null;
        double maxRatio = Double.MIN_VALUE;
        // Перебираем все фигуры из списка
        for (Figure figure : figures) {
            // Проверяем, является ли текущая фигура прямоугольником
            if (figure instanceof Rectangle) {
                Rectangle rectangle = (Rectangle) figure;
                // Вычисляем диагональ и периметр прямоугольника
                double diagonal = rectangle.getDiagonal();
                double perimeter = rectangle.getPerimeter();
                // Вычисляем отношение диагонали к периметру
                double ratio = diagonal / perimeter;
                // Если текущее отношение больше максимального, обновляем переменные
                if (ratio > maxRatio) {
                    maxRatio = ratio;
                    maxRatioRectangle = rectangle;
                }

            }
        }
        rectangleRatios.put(maxRatioRectangle, maxRatio);
        return rectangleRatios;

    }

    //Find circles with radius equal to any triangle side:
    /* Алгоритм:
     * Создать пустой список для хранения кругов с радиусом, равным длине стороны треугольника.
     * Пройтись по списку фигур.
     * Для каждой фигуры:
     * Проверить, является ли она кругом.
     * Если да, сравните радиус круга с каждой стороной треугольника.
     * Если радиус круга равен длине хотя бы одной стороны треугольника, добавьте этот круг в список результатов.
     * Вернуть список найденных кругов.
     */
    public static Map<Circle, Triangle> findCirclesWithRadiusEqualToTriangleSide(List<Figure> figures) {
        Map<Circle, Triangle> circleTriangleMap = new HashMap<>();
        for (Figure figure : figures) {
            if (figure instanceof Circle) {
                Circle circle = (Circle) figure;
                for (Figure figure1 : figures) {
                    if (figure1 instanceof Triangle) {
                        Triangle triangle = (Triangle) figure1;
                        if ((circle.getRadius() == triangle.getA()) || (circle.getRadius() == triangle.getB())
                                || (circle.getRadius() == triangle.getC())) {
                            circleTriangleMap.put(circle, triangle);
                        }
                    }
                }
            }
        }
        return circleTriangleMap;

    }
    //Determine if there's a rectangle and triangle of the same color:
    /* Для решения этой задачи нам нужно пройтись по списку фигур,
     * идентифицировать прямоугольники и треугольники,
     * сохранить их цвета и затем проверить,
     * есть ли у нас как минимум один прямоугольник и один треугольник с одинаковым цветом.
     * Алгоритм:
     * Создать пустую карту для хранения информации о наличии прямоугольника и треугольника одного цвета.
     * Пройтись по списку фигур.
     * Для каждой фигуры:
     * Проверить, является ли она прямоугольником или треугольником.
     * Если да, добавить цвет фигуры в карту в качестве ключа,
     * а значение установить на true для прямоугольника и false для треугольника.
     * После завершения прохода по списку фигур, пройтись по карте и проверить,
     * есть ли у нас одновременно прямоугольник и треугольник с одним и тем же цветом.
     * Вернуть карту с результатами.
     */
   public static Map<String, Boolean> hasRectangleAndTriangleOfSameColor(List<Figure> figures) {
       Map<String, Boolean> colorSame = new HashMap<>();
       for (Figure figure : figures) {
           if (figure instanceof Rectangle) {
               Rectangle rectangle = (Rectangle) figure;
               colorSame.put(rectangle.toString(),true);
           }
           if (figure instanceof Triangle) {
               Triangle triangle = (Triangle) figure;
               colorSame.put(triangle.toString(), false);
           }
       }
       return  colorSame;

   }
}