package org.example._2024_04_08;
import lombok.*;
@Getter
@Setter
public class Manager extends Employee{
    private int managedEmployees;

    public Manager(String name, int age, double salary, Department department, int managedEmployees) {
        super(name, age, salary, department);
        this.managedEmployees = managedEmployees;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", salary=" + getSalary() +
                ", department=" + getDepartment() +
                ", managedEmployees=" + managedEmployees +
                '}';
    }
}
