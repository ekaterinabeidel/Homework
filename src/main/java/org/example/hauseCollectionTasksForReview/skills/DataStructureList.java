package org.example.hauseCollectionTasksForReview.skills;

import java.util.ArrayList;
import java.util.List;

public class DataStructureList {
    /*Список (list) - это структура данных, к. представляет собой упорядоченную коллекцию элементов,
    в к. каждый элемент имеет свой индекс. Это означает, что элементы хранятся последовательно,
    и к ним можно обращаться по их позиции в списке.
    Используемые методы:
    1. add()  для добавления элемента в конец списка.
    2. addAll() для добавления всех элементов из другой коллекции в конец списка.
    */

    // Задание 3 (SimpleHouseCollectionTasks): Вернуть список домов, в которых более 50 квартир (List)
    public static List<House> getLargeHouses(List<House> houses) {
        // Создаем пустой список для хранения домов с более чем 50 квартирами
        List<House> largeHouses = new ArrayList<>();

        // Перебираем все дома в списке
        for (House house : houses) {
            // Проверяем, есть ли в текущем доме более 50 квартир
            if (house.flats.size() > 50) {
                // Если да, добавляем дом в список
                largeHouses.add(house);
            }
        }

        // Возвращаем список домов с более чем 50 квартирами
        return largeHouses;
    }
    // Задание 1 (DetailedHouseCollectionTasks):
    // Вернуть список всех коробок, вес которых больше среднего веса всех коробок (List)
    public static List<Box> getBoxesHeavierThanAverage(List<House> houses) {
        // Создаем пустой список для хранения коробок, вес которых больше среднего
        List<Box> heavyBoxes = new ArrayList<>();

        // Переменные для хранения общего веса и количества коробок
        double totalWeight = 0;
        int boxCount = 0;

        // Первый проход: вычисляем общий вес и количество коробок
        for (House house : houses) {
            for (Flat flat : house.flats) {
                for (Room room : flat.roomList) {
                    for (Box box : room.boxes) {
                        // Увеличиваем общий вес и количество коробок
                        totalWeight += box.weight;
                        boxCount++;
                    }
                }
            }
        }

        // Вычисляем средний вес коробок
        double averageWeight = boxCount > 0 ? totalWeight / boxCount : 0;

        // Второй проход: добавляем коробки, вес которых больше среднего, в список
        for (House house : houses) {
            for (Flat flat : house.flats) {
                for (Room room : flat.roomList) {
                    for (Box box : room.boxes) {
                        // Проверяем, если вес коробки больше среднего
                        if (box.weight > averageWeight) {
                            // Если да, добавляем коробку в список
                            heavyBoxes.add(box);
                        }
                    }
                }
            }
        }

        // Возвращаем список коробок, вес которых больше среднего
        return heavyBoxes;
    }
    // Задание 2 (MoreAdvancedHouseCollectionTasks):
    // Вернуть список всех дверных проемов в домах, где есть лифт (List)
    public static List<Doorway> getDoorwaysInElevatorHouses(List<House> houses) {
        // Создаем пустой список для хранения всех дверных проемов
        List<Doorway> doorways = new ArrayList<>();

        // Перебираем все дома в списке
        for (House house : houses) {
            // Проверяем, есть ли в текущем доме лифт
            if (house.hasElevator) {
                // Если есть лифт, перебираем все квартиры в этом доме
                for (Flat flat : house.flats) {
                    // Для каждой комнаты в квартире добавляем ее дверной проем в список
                    for (Room room : flat.roomList) {
                        doorways.add(room.doorway);
                    }
                }
            }
        }

        // Возвращаем список всех дверных проемов в домах с лифтом
        return doorways;
    }


    // Задание 1 (ComplexHouseCollectionTasks):
    // Вернуть список коробок, которые пролезут в дверной проем по высоте во всех домах (List)
    public static List<Box> getBoxesThatFitThroughDoorways(List<House> houses) {
        // Создаем пустой список для хранения коробок, которые пролезут в дверной проем
        List<Box> fittingBoxes = new ArrayList<>();

        // Перебираем все дома в списке
        for (House house : houses) {
            // Перебираем все квартиры в текущем доме
            for (Flat flat : house.flats) {
                // Перебираем все комнаты в текущей квартире
                for (Room room : flat.roomList) {
                    // Находим самую маленькую высоту среди всех коробок в комнате
                    double smallestBoxHeight = Double.MAX_VALUE;
                    for (Box box : room.boxes) {
                        if (box.height < smallestBoxHeight) {
                            smallestBoxHeight = box.height;
                        }
                    }
                    // Проверяем, пролезает ли самая маленькая коробка в дверной проем
                    if (room.doorway.height >= smallestBoxHeight) {
                        // Если да, добавляем все коробки из комнаты в список
                        fittingBoxes.addAll(room.boxes);
                    }
                }
            }
        }

        // Возвращаем список коробок, которые пролезут в дверной проем
        return fittingBoxes;
    }
    // Задание 1 (HouseCollectionTasks_1): Вернуть список всех квартир во всех домах (List)
    public static List<Flat> getAllFlats(List<House> houses) {
        // Создаем пустой список для хранения всех квартир
        List<Flat> allFlats = new ArrayList<>();

        // Перебираем все дома в списке
        for (House house : houses) {
            // Добавляем все квартиры текущего дома в список всех квартир
            allFlats.addAll(house.flats);
        }

        // Возвращаем список всех квартир
        return allFlats;
    }



}
