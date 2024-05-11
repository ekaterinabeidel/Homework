package org.example.hauseCollectionTasksForReview.skills;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DataStructureStack {
    /*  Структура данных "стек" (stack) представляет собой коллекцию элементов,
    работающую по принципу "последним пришел, первым ушел" (LIFO - Last In, First Out).
    Это означает, что последний добавленный элемент будет первым извлеченным из стека.
    */
    // Задание 5 (HouseCollectionTasks_1):
    // Используя стек, вернуть список всех квартир в обратном порядке от последнего дома к первому (Stack)
    public static List<Flat> getFlatsInReverseOrder(List<House> houses) {
        // Создаем пустой стек для хранения квартир в обратном порядке
        Stack<Flat> stack = new Stack<>();

        // Перебираем список домов в обратном порядке
        for (int i = houses.size() - 1; i >= 0; i--) {
            // Получаем текущий дом
            House house = houses.get(i);

            // Перебираем все квартиры в текущем доме
            for (Flat flat : house.flats) {
                // Добавляем квартиру в стек
                stack.push(flat);
            }
        }

        // Создаем список для хранения квартир в правильном порядке
        List<Flat> reversedFlats = new ArrayList<>();

        // Извлекаем квартиры из стека и добавляем их в список
        while (!stack.isEmpty()) {
            reversedFlats.add(stack.pop());
        }

        // Возвращаем список квартир в обратном порядке
        return reversedFlats;
    }

}
