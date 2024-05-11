package org.example.hauseCollectionTasksForReview.taski.t1andt2;

import lombok.Getter;
import lombok.Setter;

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

