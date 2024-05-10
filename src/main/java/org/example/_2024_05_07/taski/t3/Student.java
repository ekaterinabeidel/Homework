package org.example._2024_05_07.taski.t3;

import lombok.*;

@Getter
@Setter

public class Student extends Person implements Identifiable, CommunityMember{
    private final String studentID;

    public Student(String firstName, String lastName, int age, String studentID) {
        super(firstName, lastName, age);
        this.studentID = studentID;
    }

    @Override
    public String toString() {
        return "\nStudent{" +
                "firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", age=" + getAge() +
                ", studentID='" + studentID + '\'' +
                '}';
    }
    @Override
    public String getIdentity() {
        return "ID: " + studentID + ", Имя: " + super.getFirstName() + ", Фамилия: " + super.getLastName();
    }
    @Override
    public String describe() {
        return "\nЭто студент по имени " + super.getFirstName() + " " + super.getLastName() + ", возраст " + super.getAge() + " лет, ID: " + studentID + ".";
    }

    @Override
    public String getCommunityStatus() {
        return "Активный участник сообщества" ;
    }
}
