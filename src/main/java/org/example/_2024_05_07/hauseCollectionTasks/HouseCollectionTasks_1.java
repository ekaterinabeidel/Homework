package org.example._2024_05_07.hauseCollectionTasks;

import java.util.*;

public class HouseCollectionTasks_1 {
    
    // Задание 1: Вернуть список всех квартир во всех домах (List)
    public static List<Flat> getAllFlats(List<House> houses) {
        List<Flat> allFlats = new ArrayList<>();
        for (House house : houses) {
            allFlats.addAll(house.flats);
        }
        return allFlats;
    }

    // Задание 2: Вернуть множество всех уникальных цветов, используемых в комнатах квартир (Set)
    public static Set<Color> getUniqueRoomColors(List<House> houses) {
        Set<Color> colors = new HashSet<>();
        for (House house : houses) {
            for (Flat flat : house.flats) {
                for (Room room : flat.roomList) {
                    colors.add(room.color);
                }
            }
        }
        return colors;
    }

    // Задание 3: Вернуть карту, ключами которой являются номера этажей, а значениями - количество квартир на этом этаже (Map)
    public static Map<Integer, Integer> getFlatsCountByFloor(House house) {
        Map<Integer, Integer> floorMap = new HashMap<>();
        for (Flat flat : house.flats) {
            int floor = flat.floor;
            floorMap.put(floor, floorMap.getOrDefault(floor, 0) + 1);
        }
        return floorMap;
    }

        // Задание 4: Используя очередь, вернуть список номеров квартир в порядке, в котором они появляются, начиная с первого подъезда (Queue)
        public static List<Integer> getFlatNumbersInOrder(House house) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> orderedFlatNumbers = new ArrayList<>();
        for (Flat flat : house.flats) {
            queue.add(flat.flatnumber);
        }
        while (!queue.isEmpty()) {
            orderedFlatNumbers.add(queue.poll());
        }
        return orderedFlatNumbers;
    }

    // Задание 5: Используя стек, вернуть список всех квартир в обратном порядке от последнего дома к первому (Stack)
    public static List<Flat> getFlatsInReverseOrder(List<House> houses) {
        Stack<Flat> stack = new Stack<>();
        for (int i = houses.size() - 1; i >= 0; i--) {
            House house = houses.get(i);
            for (Flat flat : house.flats) {
                stack.push(flat);
            }
        }
        List<Flat> reversedFlats = new ArrayList<>();
        while (!stack.isEmpty()) {
            reversedFlats.add(stack.pop());
        }
        return reversedFlats;
    }
    
    public static void main(String[] args) {
        List<House> houses = HouseGenerator.generateHouses(3);
        House house = new House();
        System.out.println("Все квартиры: " + getAllFlats(houses).size());
        System.out.println("Уникальные цвета комнат: " + getUniqueRoomColors(houses).size());
        System.out.println("Квартиры по этажам: " + getFlatsCountByFloor(house));
        System.out.println("Номера квартир по порядку: " + getFlatNumbersInOrder(house));
        System.out.println("Квартиры в обратном порядке: " + getFlatsInReverseOrder(houses));
    }
}
