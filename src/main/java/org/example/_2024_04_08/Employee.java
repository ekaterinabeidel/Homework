package org.example._2024_04_08;
import lombok.*;
@Getter
@Setter
@AllArgsConstructor

public class Employee {
    private String name;
    private int age;
    private double salary;
    private Department department;

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", department=" + department +
                '}';
    }

}
