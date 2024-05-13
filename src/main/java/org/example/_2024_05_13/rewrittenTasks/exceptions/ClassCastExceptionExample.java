package org.example._2024_05_13.rewrittenTasks.exceptions;

import java.util.List;

public class ClassCastExceptionExample {
    //Задание 5 (MoreAdvancedHouseCollectionTasks):
    //Подсчитать суммарное количество комнат в квартирах, окрашенных в определенный цвет

    public static int countRoomsByColor(List<House> houses, Color color) {
        int roomCount = 0;
        for (House house : houses) {
            for (Flat flat : house.flats) {
                for (Room room : flat.roomList) {
                    try {
                        if (room.color == color) {
                            roomCount++;
                        }
                    } catch (ClassCastException e) {
                        System.err.println("Ошибка при сравнении цветов комнат: " + e.getMessage());
                    }
                }
            }
        }
        return roomCount;
    }
}

