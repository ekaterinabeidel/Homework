package org.example._2024_05_07.skills;

import java.util.List;

public class SumOperations {
    /* Операции с подсчетом суммы обычно включают в себя следующий общий алгоритм решения:
    Сумма = 0
    Для каждого элемента в коллекции:
        Добавить значение элемента к Сумме
    Вернуть Сумму
     */

    //Задание 1 (SimpleHouseCollectionTasks):
    //Вернуть количество подъездов во всех домах.
    public static int getTotalEntrances(List<House> houses) {
        int totalEntrances = 0;
        for (House house : houses) {
            totalEntrances += house.entrance;
        }
        return totalEntrances;
    }
    //Задание 5 (SimpleHouseCollectionTasks):
    //Вернуть общее количество комнат во всех домах
    public static int getTotalRooms(List<House> houses) {
        int totalRooms = 0;
        for (House house : houses) {
            for (Flat flat : house.flats) {
                totalRooms += flat.roomList.size();
            }
        }
        return totalRooms;
    }
    //Задание 3 (AdvancedHouseCollectionTasks):
    // Подсчитать общее количество подъездов в домах,
    // которые имеют больше 100 квартир (List)
    public static int getTotalEntrancesInLargeHouses(List<House> houses) {
        int totalEntrances = 0;
        for (House house : houses) {
            if (house.flats.size() > 100) {
                totalEntrances += house.entrance;
            }
        }
        return totalEntrances;
    }
    //Задание 5 (MoreAdvancedHouseCollectionTasks):
    //Подсчитать суммарное количество комнат в квартирах, окрашенных в определенный цвет
    public static int countRoomsByColor(List<House> houses, Color color) {
        int roomCount = 0;
        for (House house : houses) {
            for (Flat flat : house.flats) {
                for (Room room : flat.roomList) {
                    if (room.color == color) {
                        roomCount++;
                    }
                }
            }
        }
        return roomCount;
    }


}
