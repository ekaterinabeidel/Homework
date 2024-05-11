package org.example.hauseCollectionTasksForReview.skills;

import java.util.List;

public class Boolean {
    //Задание 4 (SimpleHouseCollectionTasks):
    // Проверить, есть ли хотя бы один дом без лифта (List)
    public static boolean hasHouseWithoutElevator(List<House> houses) {
        for (House house : houses) {
            if (!house.hasElevator) {
                return true; // Если хотя бы один дом без лифта, вернуть true
            }
        }
        return false; // Если все дома имеют лифт, вернуть false
    }
    //Задание 4 (AdvancedHouseCollectionTasks):
    // Определить, все ли дома имеют лифт (List)
    public static boolean areAllHousesWithElevator(List<House> houses) {
        for (House house : houses) {
            if (!house.hasElevator) {
                return false; // Если хотя бы один дом без лифта, вернуть false
            }
        }
        return true; // Если все дома имеют лифт, вернуть true
    }
    //Задание 4 (ComplexHouseCollectionTasks):
    // Определить, есть ли дом, где каждая квартира имеет хотя бы одну зеленую комнату (List)
    public static boolean isThereAHouseWithAllFlatsHavingAGreenRoom(List<House> houses) {
        for (House house : houses) {
            boolean allFlatsHaveGreenRoom = true;
            for (Flat flat : house.flats) {
                boolean hasGreenRoom = false;
                for (Room room : flat.roomList) {
                    if (room.color == Color.GREEN) {
                        hasGreenRoom = true;
                        break; // выходим из цикла, если найдена зеленая комната
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
