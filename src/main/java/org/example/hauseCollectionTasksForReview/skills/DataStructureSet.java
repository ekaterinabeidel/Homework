package org.example.hauseCollectionTasksForReview.skills;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DataStructureSet {
    /* Set — коллекция, к. хранит только уникальные элементы, не допуская дубликатов.
    HashSet — одна из реализаций интерфейса Set, к. хранит набор уникальных элементов.
    Он основан на хэш-таблице, что делает операции добавления, удаления и поиска элементов очень эффективными.
    Используемые методы:
    add() добавляет элемент в множество, если его там еще нет, в противном случае ничего не происходит.
     */
    // ЗАМЕТКА: В ЧЕМ РАЗЛИЧИЕ ДВУХ СЛЕДУЮЩИХ МЕТОДОВ?
    // Задание 2 (SimpleHouseCollectionTasks):
    // Вернуть список всех этажей во всех домах, где имеется лифт (List и Set для исключения повторений)
    public static List<Integer> getFloorsWithElevators(List<House> houses) {
        Set<Integer> uniqueFloors = new HashSet<>();

        // Перебираем все дома
        for (House house : houses) {
            // Если в текущем доме есть лифт, добавляем этажи в Set
            if (house.hasElevator) {
                for (Flat flat : house.flats) {
                    uniqueFloors.add(flat.floor);
                }
            }
        }

        // Возвращаем список уникальных этажей
        return new ArrayList<>(uniqueFloors);
    }
    // Задание 2 (AdvancedHouseCollectionTasks):
    // Вернуть список этажей, на которых есть лифт (List и Set для исключения повторений)
    public static List<Integer> getFloorsWithElevator(List<House> houses) {
        Set<Integer> floorsWithElevator = new HashSet<>();

        // Перебираем все дома
        for (House house : houses) {
            // Если в текущем доме есть лифт, добавляем этажи в Set
            if (house.hasElevator) {
                for (Flat flat : house.flats) {
                    floorsWithElevator.add(flat.floor);
                }
            }
        }

        // Возвращаем список уникальных этажей
        return new ArrayList<>(floorsWithElevator);
    }
    // Задание 2 (HouseCollectionTasks_1): Вернуть множество всех уникальных цветов, используемых в комнатах квартир (Set)
    public static Set<Color> getUniqueRoomColors(List<House> houses) {
        // Создаем пустое множество для хранения уникальных цветов
        Set<Color> colors = new HashSet<>();

        // Перебираем все дома в списке
        for (House house : houses) {
            // Для каждого дома перебираем все квартиры
            for (Flat flat : house.flats) {
                // Для каждой квартиры перебираем все комнаты
                for (Room room : flat.roomList) {
                    // Добавляем цвет комнаты в множество
                    colors.add(room.color);
                }
            }
        }
        // Возвращаем множество всех уникальных цветов
        return colors;
    }
}
