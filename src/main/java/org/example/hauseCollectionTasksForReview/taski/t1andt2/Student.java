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
public class Student implements Comparable<Student>{

    private String studentName;
    private String studentSurname;
    private int studentAge;
    private List<Course> listOfCoursesForStudent;

    public Student(String studentName, String studentSurname, int studentAge, List<Course> listOfCoursesForStudent) {
        this.studentName = studentName;
        this.studentSurname = studentSurname;
        setStudentAge(studentAge);
        this.listOfCoursesForStudent =  new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentName='" + studentName + '\'' +
                ", studentSurname='" + studentSurname + '\'' +
                ", studentAge=" + studentAge +
                ", listOfCoursesForStudent.size()=" + listOfCoursesForStudent.size() +
                '}';
    }

    public Student(String studentName, String studentSurname, int studentAge) {
        this.studentName = studentName;
        this.studentSurname = studentSurname;
        this.studentAge = studentAge;
    }

    public void setStudentAge(int studentAge) {
        if (studentAge > 0)
            this.studentAge = studentAge;
        else {
            System.out.println("Age cannot be negative.");
        }
    }


    public void addCourseToStudentCourseEnrollmentsList(Course course) {
        if (listOfCoursesForStudent == null) {
            listOfCoursesForStudent = new ArrayList<>();
        }
        listOfCoursesForStudent.add(course);
    }

    public void removeCourseFromStudentCourseEnrollmentsList(Course course) {
        if (!listOfCoursesForStudent.contains(course)) {
            return;
        }
        listOfCoursesForStudent.remove(course);

    }

    public List<Course> getAllCoursesForStudentBySurname(String studentSurname) {
        if (this.studentSurname.equals(studentSurname)) {
            return new LinkedList<>(listOfCoursesForStudent);
        }
        return new LinkedList<>();
    }
    public List<Course> getAllCoursesForStudentByName(String studentName) {
        if (this.studentName.equals(studentName)) {
            return new LinkedList<>(listOfCoursesForStudent);
        }
        return new LinkedList<>();
    }


    @Override
    public int compareTo(Student o) {
        return Integer.compare(this.studentAge, o.studentAge);
    }
}
