package org.example._2024_05_07.taski.t3;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
public class Person {
    private String firstName;
    private String lastName;
    private int age;

    public String toString() {
        return "\nPerson{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }

    public String describe() {
        return "\nЭто человек по имени " + firstName + " " + lastName + ", возраст " + age + " лет.";
    }
}
