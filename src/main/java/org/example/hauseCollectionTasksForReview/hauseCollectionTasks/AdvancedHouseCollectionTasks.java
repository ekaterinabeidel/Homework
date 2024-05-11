package org.example.hauseCollectionTasksForReview.hauseCollectionTasks;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AdvancedHouseCollectionTasks {

    // Задание 1: Вернуть список номеров квартир, у которых количество комнат больше среднего количества комнат по всем квартирам каждого дома (List)
    public static List<Integer> getFlatsWithMoreRoomsThanAverage(List<House> houses) {
        List<Integer> flatNumbers = new ArrayList<>();
        double totalRooms = 0;
        int totalFlats = 0;

        for (House house : houses) {
            for (Flat flat : house.flats) {
                totalRooms += flat.roomList.size();
                totalFlats++;
            }
        }

        double averageRooms = totalRooms / totalFlats;

        for (House house : houses) {
            for (Flat flat : house.flats) {
                if (flat.roomList.size() > averageRooms) {
                    flatNumbers.add(flat.flatnumber);
                }
            }
        }

        return flatNumbers;
    }

    // Задание 2: Вернуть список этажей, на которых есть лифт (List и Set для исключения повторений)
    public static List<Integer> getFloorsWithElevator(List<House> houses) {
        Set<Integer> floorsWithElevator = new HashSet<>();
        for (House house : houses) {
            if (house.hasElevator) {
                for (Flat flat : house.flats) {
                    floorsWithElevator.add(flat.floor);
                }
            }
        }
        return new ArrayList<>(floorsWithElevator);
    }

    // Задание 3: Подсчитать общее количество подъездов в домах, которые имеют больше 100 квартир (List)
    public static int getTotalEntrancesInLargeHouses(List<House> houses) {
        int totalEntrances = 0;
        for (House house : houses) {
            if (house.flats.size() > 100) {
                totalEntrances += house.entrance;
            }
        }
        return totalEntrances;
    }

    // Задание 4: Определить, все ли дома имеют лифт (List)
    public static boolean areAllHousesWithElevator(List<House> houses) {
        for (House house : houses) {
            if (!house.hasElevator) {
                return false;
            }
        }
        return true;
    }

    // Задание 5: Подсчитать общее количество квартир, расположенных на первом этаже (List)
    public static int getTotalFirstFloorFlats(List<House> houses) {
        int count = 0;
        for (House house : houses) {
            for (Flat flat : house.flats) {
                if (flat.floor == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        List<House> houses = HouseGenerator.generateHouses(3); // Генерируем дома для примера
        System.out.println("Список номеров квартир с количеством комнат больше среднего:");
        System.out.println(getFlatsWithMoreRoomsThanAverage(houses));
        System.out.println("Список этажей с лифтом:");
        System.out.println(getFloorsWithElevator(houses));
        System.out.println("Общее количество подъездов в домах с более чем 100 квартирами:");
        System.out.println(getTotalEntrancesInLargeHouses(houses));
        System.out.println("Все ли дома имеют лифт?");
        System.out.println(areAllHousesWithElevator(houses));
        System.out.println("Общее количество квартир на первом этаже:");
        System.out.println(getTotalFirstFloorFlats(houses));

    }
}