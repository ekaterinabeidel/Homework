package org.example._2024_05_07.skills;

import lombok.ToString;

import java.util.List;

@ToString
public class House {

    public List<Flat> flats;
    public int entrance;
    public boolean hasElevator;


}


public class Flat {
    public List<Room> roomList;
    public double square;
    public int flatnumber;
    public int floor;

    @Override
    public String toString() {
        return "Flat[" +
                "ROOMS: " + roomList.size() +
                ", SQUARE: " + square +
                ", FLAT NUMBER: " + flatnumber +
                ", FLOOR: " + floor +
                ']';
    }
}

public class Room {
    public double length;
    public double width;
    public double height;
    public Doorway doorway;
    public List<Box> boxes;
    public Color color;

    @Override
    public String toString() {
        return "Room[" +
                "L: " + length +
                ", W: " + width +
                ", H: " + height +
                ", DOORWAY: " + doorway +
                ", BOXES SIZE: " + boxes.size() +
                ", COLOR: " + color +
                ']';
    }
}

public class Doorway {
    public double length;
    public double height;

    @Override
    public String toString() {
        return "Doorway[" +
                " L: " + length +
                ", H: " + height +
                ']';
    }
}

@ToString
public enum Color {
    WHITE, BLACK, GREEN, YELLOW, RED, BLUE, PURPLE, BRAUN;
}


public class Box {
    public double length;
    public double width;
    public double height;
    public double weight;
    public Color color;

    @Override
    public String toString() {
        return "Box[" +
                "L: " + length +
                ", W: " + width +
                ", H: " + height +
                ", WEIGHT: " + weight +
                ", COLOR: " + color +
                ']';
    }
}

class Main {
    public static void main(String[] args) {

    }
}