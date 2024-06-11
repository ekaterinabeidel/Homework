package org.example._2024_06_10;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Student {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private double grade;
    private Major major;
    private int year;
    private boolean fullTime;
}
