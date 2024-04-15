package org.example._2024_04_10;
import lombok.*;

import java.util.Arrays;

@Getter
@Setter
@AllArgsConstructor
public class Person {
    private String name;
    private String surname;
    private Address address;
    private double salary;
    private Car car;
    private BankAccount bankAccounts;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", address=" + address +
                ", salary=" + salary +
                ", car=" + car +
                ", bankAccounts=" + bankAccounts +
                '}';
    }
}
