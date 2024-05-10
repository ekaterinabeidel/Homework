package org.example._2024_05_07.hauseCollectionTasks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComplexHouseCollectionTasks {

    // Задание 1: Вернуть список коробок, которые пролезут в дверной проем по высоте во всех домах (List)
    public static List<Box> getBoxesThatFitThroughDoorways(List<House> houses) {
        List<Box> fittingBoxes = new ArrayList<>();
        for (House house : houses) {
            for (Flat flat : house.flats) {
                for (Room room : flat.roomList) {
                    double smallestBoxHeight = Double.MAX_VALUE;
                    for (Box box : room.boxes) {
                        if (box.height < smallestBoxHeight) {
                            smallestBoxHeight = box.height;
                        }
                    }
                    if (room.doorway.height >= smallestBoxHeight) {
                        fittingBoxes.addAll(room.boxes);
                    }
                }
            }
        }
        return fittingBoxes;
    }

    // Задание 2: Вернуть количество квартир, в которых хотя бы одна комната не содержит коробок (List)
    public static int countFlatsWithEmptyRooms(List<House> houses) {
        int count = 0;
        for (House house : houses) {
            for (Flat flat : house.flats) {
                boolean hasEmptyRoom = false;
                for (Room room : flat.roomList) {
                    if (room.boxes.isEmpty()) {
                        hasEmptyRoom = true;
                        break;
                    }
                }
                if (hasEmptyRoom) {
                    count++;
                }
            }
        }
        return count;
    }

    // Задание 3: Вернуть среднюю высоту дверных проемов всех комнат (List)
    public static double getAverageDoorwayHeight(List<House> houses) {
        double totalHeight = 0;
        int count = 0;
        for (House house : houses) {
            for (Flat flat : house.flats) {
                for (Room room : flat.roomList) {
                    totalHeight += room.doorway.height;
                    count++;
                }
            }
        }
        return count > 0 ? totalHeight / count : 0;
    }

    // Задание 4: Определить, есть ли дом, где каждая квартира имеет хотя бы одну зеленую комнату (List)
    public static boolean isThereAHouseWithAllFlatsHavingAGreenRoom(List<House> houses) {
        for (House house : houses) {
            boolean allFlatsHaveGreenRoom = true;
            for (Flat flat : house.flats) {
                boolean hasGreenRoom = false;
                for (Room room : flat.roomList) {
                    if (room.color == Color.GREEN) {
                        hasGreenRoom = true;
                        break;
                    }
                }
                if (!hasGreenRoom) {
                    allFlatsHaveGreenRoom = false;
                    break;
                }
            }
            if (allFlatsHaveGreenRoom) {
                return true;
            }
        }
        return false;
    }

    // Задание 5: Вернуть карту, где ключи — это номера этажей, а значения — списки всех коробок на этом этаже (List, Map)
    public static Map<Integer, List<Box>> getBoxesPerFloor(List<House> houses) {
        Map<Integer, List<Box>> boxesByFloor = new HashMap<>();
        for (House house : houses) {
            for (Flat flat : house.flats) {
                for (Room room : flat.roomList) {
                    int floor = flat.floor;
                    List<Box> boxesOnFloor = boxesByFloor.getOrDefault(floor, new ArrayList<>());
                    boxesOnFloor.addAll(room.boxes);
                    boxesByFloor.put(floor, boxesOnFloor);
                }
            }
        }
        return boxesByFloor;
    }

    public static void main(String[] args) {
        List<House> houses = HouseGenerator.generateHouses(1);

        System.out.println("Коробки, подходящие по высоте для дверных проемов: " + getBoxesThatFitThroughDoorways(houses).size());
        System.out.println("Квартиры с хотя бы одной пустой комнатой: " + countFlatsWithEmptyRooms(houses));
        System.out.println("Средняя высота дверных проемов: " + getAverageDoorwayHeight(houses));
        System.out.println("Дом с квартирами, в каждой из которых есть зеленая комната: " + isThereAHouseWithAllFlatsHavingAGreenRoom(houses));
        System.out.println("Коробки по этажам: " + getBoxesPerFloor(houses));
    }
}
