package org.example._2024_05_07.skills;

import java.util.List;

public class Average {
    /* Общий алгоритм для операций с подсчетом среднего значения в коллекции:
    Сумма = 0
    Количество_элементов = 0
    Для каждого элемента в коллекции:
        Добавить значение элемента к Сумме
        Увеличить Количество_элементов на 1
Среднее_значение = Сумма / Количество_элементов
Вернуть Среднее_значение
     */
    //Задание 3 (DetailedHouseCollectionTasks):
    //Найти средний вес коробок в комнатах с зелеными стенами.
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
    //Задание 3 (ComplexHouseCollectionTasks)
    //Вернуть среднюю высоту дверных проемов всех комнат.
    public static double getAverageDoorwayHeight(List<House> houses) {
        double totalHeight = 0;
        int count = 0;

        for (House house : houses) {
            for (Flat flat : house.flats) {
                for (Room room : flat.roomList) {
                    if (room.doorway != null) { // Check if the room has a doorway
                        totalHeight += room.doorway.height;
                        count++;
                    }
                }
            }
        }

        return count > 0 ? totalHeight / count : 0;
    }



}
