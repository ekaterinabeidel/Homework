package org.example._2024_05_13.rewrittenTasks.exceptions;

import java.util.ArrayList;
import java.util.List;

public class IllegalArgumentExceptionExample {
    // Задание 3 (SimpleHouseCollectionTasks): Вернуть список домов, в которых более 50 квартир (List)
    public static List<House> getLargeHouses(List<House> houses) {
        if (houses == null) {
            throw new IllegalArgumentException("Список домов не может быть null");
        }

        List<House> largeHouses = new ArrayList<>();
        for (House house : houses) {
            if (house.flats.size() > 50) {
                largeHouses.add(house);
            }
        }
        return largeHouses;
    }

}
