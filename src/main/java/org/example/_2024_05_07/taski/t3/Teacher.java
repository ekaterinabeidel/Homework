package org.example._2024_05_07.taski.t3;
import lombok.*;
@Getter
@Setter
@ToString
public class Teacher extends Person implements CommunityMember {
    private String subject;

    public Teacher(String firstName, String lastName, int age, String subject) {
        super(firstName, lastName, age);
        this.subject = subject;
    }

    @Override
    public String getCommunityStatus() {
        return "Администратор сообщества";
    }
}
