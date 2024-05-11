package org.example.hauseCollectionTasksForReview.taski.t3;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

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
