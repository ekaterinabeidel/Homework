package org.example._2024_05_13.rewrittenTasks.exceptions;

import java.util.List;

public class ArithmeticExceptionExample {

    //Задание 3 (ComplexHouseCollectionTasks)
    //Вернуть среднюю высоту дверных проемов всех комнат.
    public static double getAverageDoorwayHeight(List<House> houses) {
        double totalHeight = 0;
        int count = 0;

        for (House house : houses) {
            for (Flat flat : house.flats) {
                for (Room room : flat.roomList) {
                    if (room.doorway != null) {
                        totalHeight += room.doorway.height;
                        count++;
                    }
                }
            }
        }
        try {
            if (count == 0) {
                throw new ArithmeticException("Нет комнат с дверными проемами для вычисления средней высоты!");
            }
            return totalHeight / count;
        } catch (ArithmeticException e) {
            System.err.println("Ошибка при вычислении средней высоты: " + e.getMessage());
            return 0;
        }

    }
}
