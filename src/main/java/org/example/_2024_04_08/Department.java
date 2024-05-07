package org.example._2024_04_08;
import lombok.Getter;
@Getter
public enum Department {
    IT("IT", 1),
    MARKETING("Marketing", 2),
    FINANCE ("Finance", 3);
    private String name;
    private int number;

    Department(String name, int number) {
        this.name = name;
        this.number = number;
    }
}
