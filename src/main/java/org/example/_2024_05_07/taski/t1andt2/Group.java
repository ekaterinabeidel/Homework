package org.example._2024_05_07.taski.t1andt2;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class Group {
    private String groupName;
    private List<Student> listOfStudentsToGroup;

    public Group(String groupName) {
        this.groupName = groupName;
        this.listOfStudentsToGroup = new ArrayList<>();
    }

    public void addStudent(Student student) {
        listOfStudentsToGroup.add(student);
    }

}

