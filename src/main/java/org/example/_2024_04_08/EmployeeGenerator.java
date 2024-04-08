package org.example._2024_04_08;
import com.github.javafaker.Faker;
public class EmployeeGenerator {
    private static final Faker faker = new Faker();
    public static Manager generateManager() {
        String name = faker.name().fullName();
        int age = faker.number().numberBetween(18, 65);
        double salary = faker.number().randomDouble(2, 2500, 8500);
        Department department = Department.FINANCE;
        int managedEmployees = faker.number().numberBetween(1, 10);
        return new Manager (name, age, salary, department, managedEmployees);
    }
    public static Developer generateDeveloper() {
        String name = faker.name().fullName();
        int age = faker.number().numberBetween(18, 65);
        double salary = faker.number().randomDouble(2, 2500, 8500);
        Department department = Department.IT;
        String programmingLanguage = faker.programmingLanguage().name();
        return new Developer (name, age, salary, department, programmingLanguage);
    }

}
