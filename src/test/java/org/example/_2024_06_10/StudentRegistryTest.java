package org.example._2024_06_10;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class StudentRegistryTest {
    Student student1 = StudentRegistry.createStudent();
    Student student2 = StudentRegistry.createStudent(Major.Biology, 3.0, 1);
    Student student3 = StudentRegistry.createStudent(Major.Computer_Science, 2.0, 1);

    @BeforeEach
    void setUp() {
        StudentRegistry.getStudents().clear();
    }

    @Test
    void addStudent() {
        StudentRegistry.addStudent(student1);
        assertTrue(StudentRegistry.getStudents().containsKey(student1.getId()));

    }

    @Test
    void addStudentWithException() {
        StudentRegistry.addStudent(student1);
        assertThrows(IllegalArgumentException.class,
                () -> StudentRegistry.addStudent(student1));
    }

    @Test
    void removeStudent() {
        StudentRegistry.addStudent(student1);
        StudentRegistry.removeStudent(student1.getId());
        assertFalse(StudentRegistry.getStudents().containsKey(student1.getId()));
    }

    @Test
    void removeStudentWithException() {
        StudentRegistry.addStudent(student1);
        StudentRegistry.removeStudent(student1.getId());
        assertThrows(NoSuchElementException.class,
                () -> StudentRegistry.removeStudent(student1.getId()));
    }

    @Test
    void findStudentsByMajor() {
        Student student1 = StudentRegistry.createStudent(Major.Biology, 3.0, 1);
        Student student2 = StudentRegistry.createStudent(Major.Biology, 3.0, 1);
        Student student3 = StudentRegistry.createStudent(Major.Computer_Science, 2.0, 1);

        StudentRegistry.addStudent(student1);
        StudentRegistry.addStudent(student2);
        StudentRegistry.addStudent(student3);
        List<Student> studentList = StudentRegistry.findStudentsByMajor(Major.Biology);
        assertEquals(2, studentList.size());
    }

    @Test
    void calculateAverageGrade() {
        Student student1 = StudentRegistry.createStudent(Major.Business, 4.0, 1);
        StudentRegistry.addStudent(student1);
        Student student2 = StudentRegistry.createStudent(Major.Biology, 3.0, 1);
        StudentRegistry.addStudent(student2);
        double average = StudentRegistry.calculateAverageGrade();
        assertEquals(3.5, average);

    }

    @Test
    void calculateAverageGradeZero() {
        double average = StudentRegistry.calculateAverageGrade();
        assertEquals(0.0, average);
    }

    @Test
    void listStudentsByYear() {
        StudentRegistry.addStudent(student1);
        StudentRegistry.addStudent(student2);
        StudentRegistry.addStudent(student3);
        List<Student> studentList = StudentRegistry.listStudentsByYear(1);
        assertEquals(2, studentList.size());
    }

    @Test
    void getStudents() {
        StudentRegistry.addStudent(student1);
        Student st = StudentRegistry.getStudent(student1.getId());
        assertEquals(student1.getId(), st.getId());
    }

    @Test
    void getStudentsWithException() {
        assertThrows(NoSuchElementException.class,
                () -> StudentRegistry.getStudent(student1.getId()));
    }

    @Test
    void getTotalNumberOfStudents() {
        StudentRegistry.generateStudents(10);
        int total = StudentRegistry.getTotalNumberOfStudents();
        assertEquals(10, total);
    }

    @Test
    void getStudentsWithGradeAbove() {
        Student student1 = StudentRegistry.createStudent(Major.Business, 4.0, 1);
        Student student2 = StudentRegistry.createStudent(Major.Biology, 3.0, 1);
        Student student3 = StudentRegistry.createStudent(Major.Computer_Science, 2.0, 1);

        StudentRegistry.addStudent(student1);
        StudentRegistry.addStudent(student2);
        StudentRegistry.addStudent(student3);
        List<Student> studentList = StudentRegistry.getStudentsWithGradeAbove(3.0);
        assertEquals(1, studentList.size());
    }

    @Test
    void getAverageGradeByMajor() {
        Student student = StudentRegistry.createStudent(Major.Business, 4.0, 1);
        StudentRegistry.addStudent(student);
        Student student1 = StudentRegistry.createStudent(Major.Biology, 3.0, 3);
        StudentRegistry.addStudent(student1);
        Student student2 = StudentRegistry.createStudent(Major.Computer_Science, 2.0, 1);
        StudentRegistry.addStudent(student2);
        Student student3 = StudentRegistry.createStudent(Major.Computer_Science, 2.5, 1);
        StudentRegistry.addStudent(student3);
        double average = StudentRegistry.getAverageGradeByMajor(Major.Computer_Science);
        assertEquals(2.25, average);
    }

    @Test
    void isStudentPresentPositive() {
        StudentRegistry.addStudent(student1);
        boolean isPresent = StudentRegistry.isStudentPresent(student1.getEmail());
        assertTrue(isPresent);
    }

    @Test
    void isStudentPresentNegative() {
        boolean isPresent = StudentRegistry.isStudentPresent(student1.getEmail());
        assertFalse(isPresent);
    }
}