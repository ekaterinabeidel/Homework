package org.example._2024_05_13.rewrittenTasks.exceptions;

import org.example._2024_05_07.skills.House;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HouseGenerator {
    private static final Random random = new Random();

    public static List<org.example._2024_05_07.skills.House> generateHouses(int numberOfHouses) {
        List<org.example._2024_05_07.skills.House> houses = new ArrayList<>();
        for (int i = 0; i < numberOfHouses; i++) {
            org.example._2024_05_07.skills.House house = new org.example._2024_05_07.skills.House();
            house.entrance = random.nextInt(10) + 1;
            house.hasElevator = random.nextBoolean();

            List<org.example._2024_05_07.skills.Flat> flats = new ArrayList<>();
            int floors = random.nextInt(99) + 1;//поставить maxHausFloor вместо floors
            int flatsPerFloor = random.nextInt(10) + 1;
            for (int floor = 0; floor < floors; floor++) {
                for (int flatIndex = 0; flatIndex < flatsPerFloor; flatIndex++) {
                    flats.add(generateFlat(floor));
                }
            }
            house.flats = flats;
            houses.add(house);
        }
        return houses;
    }

    private static org.example._2024_05_07.skills.Flat generateFlat(int floor) {
        org.example._2024_05_07.skills.Flat flat = new org.example._2024_05_07.skills.Flat();
        flat.floor = floor;
        flat.flatnumber = random.nextInt(1000);
        int roomsCount = random.nextInt(5) + 1;
        List<org.example._2024_05_07.skills.Room> rooms = new ArrayList<>();
        double totalSquare = 0;

        for (int i = 0; i < roomsCount; i++) {
            org.example._2024_05_07.skills.Room room = new org.example._2024_05_07.skills.Room();
            room.length = random.nextDouble() * 10 + 1;
            room.width = random.nextDouble() * 10 + 1;
            room.height = random.nextDouble() * 3 + 2;
            room.color = org.example._2024_05_07.skills.Color.values()[random.nextInt(org.example._2024_05_07.skills.Color.values().length)];
            room.doorway = new org.example._2024_05_07.skills.Doorway();
            room.doorway.length = Math.min(room.length, room.width) - 0.5;
            room.doorway.height = room.height - 0.5;
            double roomVolume = room.length * room.width * room.height;
            room.boxes = generateBoxes(roomVolume);
            totalSquare += room.length * room.width;
            rooms.add(room);
        }
        flat.roomList = rooms;
        flat.square = totalSquare;
        return flat;
    }

    private static List<org.example._2024_05_07.skills.Box> generateBoxes(double roomVolume) {
        List<org.example._2024_05_07.skills.Box> boxes = new ArrayList<>();
        double remainingVolume = roomVolume;
        while (remainingVolume > 0) {
            org.example._2024_05_07.skills.Box box = new org.example._2024_05_07.skills.Box();
            box.length = random.nextDouble() * 2 + 0.5;
            box.width = random.nextDouble() * 2 + 0.5;
            box.height = random.nextDouble() * 2 + 0.5;
            box.weight = random.nextDouble() * 10;
            box.color = org.example._2024_05_07.skills.Color.values()[random.nextInt(org.example._2024_05_07.skills.Color.values().length)];
            double boxVolume = box.length * box.width * box.height;
            if (boxVolume <= remainingVolume) {
                boxes.add(box);
                remainingVolume -= boxVolume;
            } else {
                break;
            }
        }
        return boxes;
    }

    public static void main(String[] args) {
        List<House> houses = generateHouses(777);
        System.out.println(houses.get(0).hasElevator);
    }
}