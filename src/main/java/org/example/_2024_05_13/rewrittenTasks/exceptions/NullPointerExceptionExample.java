package org.example._2024_05_13.rewrittenTasks.exceptions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NullPointerExceptionExample {
// Задание 2 (DetailedHouseCollectionTasks):
    // Вернуть карту, где ключи — это цвета коробок, а значения — количество комнат,
    // содержащих хотя бы одну коробку такого цвета (List, Map)
public static Map<Color, Integer> getRoomCountByBoxColor(List<House> houses) {
    Map<Color, Integer> roomCountByColor = new HashMap<>();
    try {
        for (House house : houses) {
            for (Flat flat : house.flats) {
                for (Room room : flat.roomList) {
                    for (Box box : room.boxes) {
                        try {
                            Color color = box.color;
                            roomCountByColor.put(color, roomCountByColor.getOrDefault(color, 0) + 1);
                        } catch (NullPointerException e) {
                            System.err.println("Ошибка: " + e.getMessage());
                        }
                    }
                }
            }
        }
    } catch (NullPointerException e) {
        System.err.println("Ошибка: " + e.getMessage());
    }
    return roomCountByColor;
}

}
