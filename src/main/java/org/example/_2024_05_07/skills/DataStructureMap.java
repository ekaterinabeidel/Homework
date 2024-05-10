package org.example._2024_05_07.skills;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataStructureMap {
    /* Map — интерфейс, к. отображает ключи на значения.
    Он представляет собой коллекцию, где каждый элемент представлен в виде пары ключ-значение.
    Ключи в Map должны быть уникальными, но значения могут повторяться.
    Map обычно используется для поиска и доступа к элементам по ключу.
    HashMap — одна из основных реализаций интерфейса Map.
    Она представляет собой хэш-таблицу, которая использует хэширование для хранения ключей и значений.
    Используемые методы:
    1. put(K key, V value): Добавляет заданное значение value по указанному ключу key в карту. ъ
    Если ключ уже присутствует в карте, то значение будет заменено новым.
    2. getOrDefault(key, defaultValue) из интерфейса Map возвращает значение, связанное с указанным ключом,
    если ключ присутствует в карте. В случае, если ключ отсутствует в карте, возвращается значение по умолчанию,
    указанное вторым аргументом метода.
    */
    // Задание 2 (DetailedHouseCollectionTasks):
    // Вернуть карту, где ключи — это цвета коробок, а значения — количество комнат,
    // содержащих хотя бы одну коробку такого цвета (List, Map)
public static Map<Color, Integer> getRoomCountByBoxColor(List<House> houses) {
    Map<Color, Integer> roomCountByColor = new HashMap<>();

    // Проходим по всем домам
    for (House house : houses) {
        // Проходим по всем квартирам
        for (Flat flat : house.flats) {
            // Проходим по всем комнатам
            for (Room room : flat.roomList) {
                // Проходим по всем коробкам в комнате
                for (Box box : room.boxes) {
                    // Получаем цвет коробки
                    Color color = box.color;
                    // Если цвет уже присутствует в карте, увеличиваем значение на 1
                    roomCountByColor.put(color, roomCountByColor.getOrDefault(color, 0) + 1);
                }
            }
        }
    }

    return roomCountByColor;
}
    // Задание 5 (MoreAdvancedHouseCollectionTasks):
    // Подсчитать суммарное количество комнат в квартирах, окрашенных в определенный цвет (Map)
    public static Map<Color, Integer> countRoomsByColor(List<House> houses) {
        Map<Color, Integer> roomColorCounts = new HashMap<>();

        // Проходим по всем домам
        for (House house : houses) {
            // Проходим по всем квартирам
            for (Flat flat : house.flats) {
                // Проходим по всем комнатам
                for (Room room : flat.roomList) {
                    // Получаем цвет комнаты
                    Color color = room.color;
                    // Если цвет уже присутствует в карте, увеличиваем значение на 1
                    roomColorCounts.put(color, roomColorCounts.getOrDefault(color, 0) + 1);
                }
            }
        }

        return roomColorCounts;
    }
    // Задание 5 (ComplexHouseCollectionTasks): Вернуть карту, где ключи — это номера этажей, а значения — списки всех коробок на этом этаже (List, Map)
    public static Map<Integer, List<Box>> getBoxesPerFloor(List<House> houses) {
        Map<Integer, List<Box>> boxesByFloor = new HashMap<>();

        // Проходим по всем домам
        for (House house : houses) {
            // Проходим по всем квартирам
            for (Flat flat : house.flats) {
                // Получаем номер этажа
                int floor = flat.floor;

                // Получаем список коробок на этом этаже
                List<Box> boxesOnFloor = boxesByFloor.getOrDefault(floor, new ArrayList<>());

                // Добавляем все коробки из каждой комнаты на этот этаж
                for (Room room : flat.roomList) {
                    boxesOnFloor.addAll(room.boxes);
                }

                // Обновляем карту с коробками на этом этаже
                boxesByFloor.put(floor, boxesOnFloor);
            }
        }

        return boxesByFloor;
    }
    // Задание 3 (HouseCollectionTasks_1):
    // Вернуть карту, ключами которой являются номера этажей, а значениями - количество квартир на этом этаже (Map)
    public static Map<Integer, Integer> getFlatsCountByFloor(House house) {
        // Создаем пустую карту для хранения количества квартир на каждом этаже
        Map<Integer, Integer> floorMap = new HashMap<>();

        // Перебираем все квартиры в доме
        for (Flat flat : house.flats) {
            // Получаем номер этажа для текущей квартиры
            int floor = flat.floor;
            // Проверяем, есть ли уже этот этаж в карте
            // Если есть, увеличиваем количество квартир на этом этаже на 1
            // Если нет, добавляем этаж в карту с начальным значением 1
            floorMap.put(floor, floorMap.getOrDefault(floor, 0) + 1);
        }

        // Возвращаем карту с количеством квартир на каждом этаже
        return floorMap;
    }


}
