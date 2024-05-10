package org.example._2024_05_07.hauseCollectionTasks;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SimpleHouseCollectionTasks {
    
    // Задание 1: Вернуть количество подъездов во всех домах (List)
    public static int getTotalEntrances(List<House> houses) {
        int totalEntrances = 0;
        for (House house : houses) {
            totalEntrances += house.entrance;
        }
        return totalEntrances;
    }

    // Задание 2: Вернуть список всех этажей во всех домах, где имеется лифт (List и Set для исключения повторений)
    public static List<Integer> getFloorsWithElevators(List<House> houses) {
        Set<Integer> uniqueFloors = new HashSet<>();
        for (House house : houses) {
            if (house.hasElevator) {
                for (Flat flat : house.flats) {
                    uniqueFloors.add(flat.floor);
                }
            }
        }
        return new ArrayList<>(uniqueFloors);
    }

    // Задание 3: Вернуть список домов, в которых более 50 квартир (List)
    public static List<House> getLargeHouses(List<House> houses) {
        List<House> largeHouses = new ArrayList<>();
        for (House house : houses) {
            if (house.flats.size() > 50) {
                largeHouses.add(house);
            }
        }
        return largeHouses;
    }

    // Задание 4: Проверить, есть ли хотя бы один дом без лифта (List)
    public static boolean hasHouseWithoutElevator(List<House> houses) {
        for (House house : houses) {
            if (!house.hasElevator) {
                return true;
            }
        }
        return false;
    }

    // Задание 5: Вернуть общее количество комнат во всех домах (List)
    public static int getTotalRooms(List<House> houses) {
        int totalRooms = 0;
        for (House house : houses) {
            for (Flat flat : house.flats) {
                totalRooms += flat.roomList.size();
            }
        }
        return totalRooms;
    }

    public static void main(String[] args) {
        List<House> houses = HouseGenerator.generateHouses(1); // Генерируем дома для примера

        System.out.println("Общее количество подъездов: " + getTotalEntrances(houses));
        System.out.println("Этажи с лифтами: " + getFloorsWithElevators(houses));
        System.out.println("Большие дома: " + getLargeHouses(houses));
        System.out.println("Наличие домов без лифта: " + hasHouseWithoutElevator(houses));
        System.out.println("Общее количество комнат: " + getTotalRooms(houses));
    }
}
