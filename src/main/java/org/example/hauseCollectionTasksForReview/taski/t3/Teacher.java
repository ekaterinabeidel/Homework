package org.example.hauseCollectionTasksForReview.taski.t3;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
