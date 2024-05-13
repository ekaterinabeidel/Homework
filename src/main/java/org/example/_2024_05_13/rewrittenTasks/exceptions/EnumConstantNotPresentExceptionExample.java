package org.example._2024_05_13.rewrittenTasks.exceptions;

import java.util.List;

public class EnumConstantNotPresentExceptionExample {
    //Задание 4 (ComplexHouseCollectionTasks):
    // Определить, есть ли дом, где каждая квартира имеет хотя бы одну зеленую комнату (List)
    public static boolean isThereAHouseWithAllFlatsHavingAGreenRoom(List<House> houses) {
        for (House house : houses) {
            boolean allFlatsHaveGreenRoom = true;
            for (Flat flat : house.flats) {
                boolean hasGreenRoom = false;
                for (Room room : flat.roomList) {
                    try {
                        if (room.color == Color.GREEN) {
                            hasGreenRoom = true;
                            break; // выходим из цикла, если найдена зеленая комната
                        }
                    } catch (EnumConstantNotPresentException e) {
                        System.err.println("Ошибка при проверке цвета комнаты: " + e.getMessage());
                    }
                }
                if (!hasGreenRoom) {
                    allFlatsHaveGreenRoom = false;
                    break; // выходим из цикла, если хотя бы одна квартира в доме не имеет зеленой комнаты
                }
            }
            if (allFlatsHaveGreenRoom) {
                return true; // если все квартиры в доме имеют зеленую комнату, возвращаем true
            }
        }
        return false; // если ни в одном доме нет всех квартир с зелеными комнатами, возвращаем false
    }
}
