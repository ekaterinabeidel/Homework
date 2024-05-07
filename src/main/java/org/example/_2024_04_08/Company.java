package org.example._2024_04_08;
import lombok.*;
@Getter
@Setter
@AllArgsConstructor
public class Company {
    private Employee[] employees;
    public void processEmployees(EmployeeProcessor processor) {
        for (Employee employee : employees) {
            processor.processEmployee(employee);
        }
    }
}
