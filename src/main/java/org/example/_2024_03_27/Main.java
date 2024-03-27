package org.example._2024_03_27;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[3];
        employees[0] = new Manager("Иван Иванов", "Менеджер", 1000, 5);
        employees[1] = new Manager("Елена Петрова", "Старший менеджер", 3000, 10);
        employees[2] = new Developer("Михаил Сидоров", "Разработчик", 2000, 5,"Java");

        for (Employee employee : employees) {
            System.out.println(employee);
            System.out.println("Bonus: " + employee.calculateBonus());
            System.out.println("--------------------------------");
        }
    }
}
