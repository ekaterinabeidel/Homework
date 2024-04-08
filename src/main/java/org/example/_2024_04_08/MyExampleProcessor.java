package org.example._2024_04_08;

public class MyExampleProcessor implements EmployeeProcessor {
    @Override
    public void processEmployee(Employee employee) {
        String additionalInfo = "";
        if (employee instanceof Manager) {
            Manager manager = (Manager) employee;
            additionalInfo = ", Managed Employees: " + manager.getManagedEmployees();
        } else if (employee instanceof Developer) {
            Developer developer = (Developer) employee;
            additionalInfo = ", Programming Language: " + developer.getProgrammingLanguage();
        }
        System.out.println("Employee: " + employee.getName()
                + ", Age: " + employee.getAge()
                + ", Salary: " + employee.getSalary()
                + ", Department: " + employee.getDepartment()
                + additionalInfo);
        System.out.println("----------------------------------------" +
                "---------------------------------------------------");
    }
}
