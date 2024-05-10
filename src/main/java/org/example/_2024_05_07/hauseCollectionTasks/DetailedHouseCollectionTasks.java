package org.example._2024_05_07.hauseCollectionTasks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DetailedHouseCollectionTasks {

    // Задание 1: Вернуть список всех коробок, вес которых больше среднего веса всех коробок (List)
    public static List<Box> getBoxesHeavierThanAverage(List<House> houses) {
        List<Box> heavyBoxes = new ArrayList<>();
        double totalWeight = 0;
        int boxCount = 0;

        for (House house : houses) {
            for (Flat flat : house.flats) {
                for (Room room : flat.roomList) {
                    for (Box box : room.boxes) {
                        totalWeight += box.weight;
                        boxCount++;
                    }
                }
            }
        }

        double averageWeight = boxCount > 0 ? totalWeight / boxCount : 0;

        for (House house : houses) {
            for (Flat flat : house.flats) {
                for (Room room : flat.roomList) {
                    for (Box box : room.boxes) {
                        if (box.weight > averageWeight) {
                            heavyBoxes.add(box);
                        }
                    }
                }
            }
        }

        return heavyBoxes;
    }

    // Задание 2: Вернуть карту, где ключи — это цвета коробок, а значения — количество комнат, содержащих хотя бы одну коробку такого цвета (List, Map)
    public static Map<Color, Integer> getRoomCountByBoxColor(List<House> houses) {
        Map<Color, Integer> roomCountByColor = new HashMap<>();
        for (House house : houses) {
            for (Flat flat : house.flats) {
                for (Room room : flat.roomList) {
                    for (Box box : room.boxes) {
                        Color color = box.color;
                        roomCountByColor.put(color, roomCountByColor.getOrDefault(color, 0) + 1);
                    }
                }
            }
        }
        return roomCountByColor;
    }

    // Задание 3: Найти средний вес коробок в комнатах с зелеными стенами (List)
    public static double getAverageWeightOfBoxesInGreenRooms(List<House> houses) {
        double totalWeight = 0;
        int boxCount = 0;
        for (House house : houses) {
            for (Flat flat : house.flats) {
                for (Room room : flat.roomList) {
                    if (room.color == Color.GREEN) {
                        for (Box box : room.boxes) {
                            totalWeight += box.weight;
                            boxCount++;
                        }
                    }
                }
            }
        }
        return boxCount > 0 ? totalWeight / boxCount : 0;
    }

    // Задание 4: Определить, в каком доме самый большой процент квартир с коробками (List)
    public static House getHouseWithHighestPercentageOfFlatsWithBoxes(List<House> houses) {
        House houseWithHighestPercentage = null;
        double maxPercentage = 0;

        for (House house : houses) {
            int flatsWithBoxesCount = 0;
            for (Flat flat : house.flats) {
                if (!flat.roomList.isEmpty()) {
                    flatsWithBoxesCount++;
                }
            }
            double percentage = (double) flatsWithBoxesCount / house.flats.size() * 100;
            if (percentage > maxPercentage) {
                maxPercentage = percentage;
                houseWithHighestPercentage = house;
            }
        }
        return houseWithHighestPercentage;
    }

    // Задание 5: Подсчитать количество квартир, которые находятся в домах без лифтов и содержат коробки (List)
    public static int countFlatsWithBoxesInHousesWithoutElevators(List<House> houses) {
        int count = 0;
        for (House house : houses) {
            if (!house.hasElevator) {
                for (Flat flat : house.flats) {
                    if (!flat.roomList.isEmpty()) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        List<House> houses = HouseGenerator.generateHouses(2);

        System.out.println("Коробки тяжелее среднего: " + getBoxesHeavierThanAverage(houses).size());
        System.out.println("Количество комнат по цветам коробок: " + getRoomCountByBoxColor(houses));
        System.out.println("Средний вес коробок в зеленых комнатах: " + getAverageWeightOfBoxesInGreenRooms(houses));
        System.out.println("Дом с самым большим процентом квартир с коробками: " + getHouseWithHighestPercentageOfFlatsWithBoxes(houses));
        System.out.println("Квартиры с коробками в домах без лифтов: " + countFlatsWithBoxesInHousesWithoutElevators(houses));
    }
}