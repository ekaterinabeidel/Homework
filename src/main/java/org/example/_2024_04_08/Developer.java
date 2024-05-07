package org.example._2024_04_08;
import lombok.*;
@Getter
@Setter

public class Developer extends Employee{
    private String programmingLanguage;

    public Developer(String name, int age, double salary, Department department, String programmingLanguage) {
        super(name, age, salary, department);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", salary=" + getSalary() +
                ", department=" + getDepartment() +
                ", programmingLanguage='" + programmingLanguage + '\'' +
                '}';
    }
}
