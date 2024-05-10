package org.example._2024_05_07.skills;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DataStructureQueue {
    /*Очередь (queue) - структура данных, к. работает по принципу "первым пришел, первым вышел" (FIFO - First In, First Out).
    Это означает, что элементы добавляются в конец очереди, а извлекаются из начала.
    Используемые методы:
    add() добавляет элемент в конец очереди.
    */
    // Задание 4 (HouseCollectionTasks_1):
    // Используя очередь, вернуть список номеров квартир в порядке, в к. они появляются, начиная с первого подъезда (Queue)
    public static List<Integer> getFlatNumbersInOrder(House house) {
        // Создаем пустую очередь для хранения номеров квартир в порядке появления
        Queue<Integer> queue = new LinkedList<>();

        // Создаем список для хранения номеров квартир в правильном порядке
        List<Integer> orderedFlatNumbers = new ArrayList<>();

        // Перебираем все квартиры в доме
        for (Flat flat : house.flats) {
            // Добавляем номер квартиры в очередь
            queue.add(flat.flatnumber);
        }

        // Извлекаем номера квартир из очереди и добавляем их в список
        while (!queue.isEmpty()) {
            orderedFlatNumbers.add(queue.poll());
        }

        // Возвращаем список номеров квартир в порядке появления
        return orderedFlatNumbers;
    }

}
