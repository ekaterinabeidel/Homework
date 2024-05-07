package org.example._2024_04_08;

public class Main {
    public static void main(String[] args) {
        Manager[] managers = new Manager[10];
        for (int i = 0; i < managers.length; i++) {
            managers[i] = EmployeeGenerator.generateManager();
        }

        Developer[] developers = new Developer[10];
        for (int i = 0; i < developers.length; i++) {
            developers[i] = EmployeeGenerator.generateDeveloper();
        }

        Employee[] employees = new Employee[managers.length + developers.length];
        System.arraycopy(managers, 0, employees, 0, managers.length);
        System.arraycopy(developers, 0, employees, managers.length, developers.length);

        Company company = new Company(employees);

        MyExampleProcessor processor = new MyExampleProcessor();
        company.processEmployees(processor);
    }

}
