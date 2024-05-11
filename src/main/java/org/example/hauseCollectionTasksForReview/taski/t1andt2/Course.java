package org.example.hauseCollectionTasksForReview.taski.t1andt2;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
public class Course {
    private String courseTitle;
    private List<Student> listOfStudentsEnrolledInCourse;

    public Course(String courseTitle) {
        this.courseTitle = courseTitle;
        this.listOfStudentsEnrolledInCourse = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseTitle='" + courseTitle + '\'' +
                ", listOfStudentsEnrolledInCourse=" + listOfStudentsEnrolledInCourse +
                '}';
    }

    public void setCourseTitle(String courseTitle) {
        if (courseTitle == null || courseTitle.isEmpty()) {
            System.out.println("Course name cannot be empty.");
            return;
        }
        this.courseTitle = courseTitle;
    }

    public void addStudentToCourse(Student student) {
        if (listOfStudentsEnrolledInCourse == null) {
            listOfStudentsEnrolledInCourse = new ArrayList<>();
        }
            listOfStudentsEnrolledInCourse.add(student);

    }

    public void removeStudentFromCourse(Student student) {

        listOfStudentsEnrolledInCourse.remove(student);
        student.removeCourseFromStudentCourseEnrollmentsList(this);

    }

    public List<Student> getAllStudentsEnrolledInCourse(String courseTitle) {
        if (this.courseTitle.equals(courseTitle)) {
            return new LinkedList<>(listOfStudentsEnrolledInCourse);
        }
        return new LinkedList<>();
    }

    public double averageStudentAgeForCourse(String courseTitle) {
        if (listOfStudentsEnrolledInCourse.isEmpty()) {
            return 0.0;
        }
        int totalAge = 0;
        for (Student student : listOfStudentsEnrolledInCourse) {
            totalAge += student.getStudentAge();
        }
        return (double) totalAge / listOfStudentsEnrolledInCourse.size();

    }
}

