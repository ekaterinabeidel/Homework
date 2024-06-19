package org.example._2024_06_17.mockTask;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @BeforeEach
    void setUp() {
        studentService = new StudentService(studentRepository);
    }

    @Mock
    StudentRepository studentRepository;
    @InjectMocks
    StudentService studentService;

    @Mock
    Student student;
    @Mock
    Course course;

    @ParameterizedTest
    @NullSource
    void registerStudentTestNSEException(Student student) {
        Assertions.assertThrows(NoSuchElementException.class,
                () -> studentService.registerStudent(student));
    }

    @Test
    void registerStudentTestVerify() {
        studentService.registerStudent(student);
        Mockito.verify(studentRepository).addStudent(student);
    }

    @Test
    void registerCourseTestVerify() {
        studentService.registerCourse(course);
        Mockito.verify(studentRepository).addCourse(course);
    }

    @ParameterizedTest
    @NullSource
    void registerCourseTestNPException(Course course) {
        Assertions.assertThrows(NullPointerException.class,
                ()-> studentService.registerCourse(course));
    }

    @Test
    void enrollStudentToCourseTest() {
        studentService.enrollStudentToCourse("1", "2");
        Mockito.verify(studentRepository).enrollStudentToCourse("1", "2");
    }

    @ParameterizedTest
    @CsvSource({"1, ", " ,1"})
    void enrollStudentToCourseTestNullStudentId(String studentId, String courseId) {
        Assertions.assertThrows(NullPointerException.class,
                () -> studentService.enrollStudentToCourse(studentId, courseId));
    }

    @ParameterizedTest
    @MethodSource("getEmptyArgs")
    void enrollStudentToCourseTestEmptyStudentId(String studentId, String courseId) {
        assertThrows(NullPointerException.class,
                () -> studentService.enrollStudentToCourse(studentId, courseId));
    }

    private static Stream<Arguments> getEmptyArgs() {
        return Stream.of(
                Arguments.of("1", ""),
                Arguments.of("", "1"),
                Arguments.of("1", null),
                Arguments.of(null, "1")
        );
    }

    @Test
    void assignGradeTest() {
        studentService.assignGrade("1", "101", 5);
        Mockito.verify(studentRepository).updateGrade("1", "101", 5);
    }

    @Test
    void assignGradeTestIAException() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> studentService.assignGrade("1", "101", -3)
        );
    }

    @ParameterizedTest
    @MethodSource("getEmptyArgs")
    void assignGradeTestEmptyArgs(String studentId, String courseId) {
        Assertions.assertThrows(NullPointerException.class,
                () -> studentService.assignGrade(studentId, courseId, 5)
        );
    }

    @Test
    void getStudentGradesTestVerify() {
        studentService.getStudentGrades("1");
        Mockito.verify(studentRepository).getGradesByStudent("1");
    }

    @ParameterizedTest
    @NullAndEmptySource
        //Задать вопрос: нужно ли в названии теста прописывать EmptyArgs
        // или аннотации достаточно
    void getStudentGradesTestEmptyArgs(String studentId) {
        Assertions.assertThrows(NullPointerException.class,
                () -> studentService.getStudentGrades(studentId));
    }

    @Test
    void calculateAverageGradeTestVerify() {
        studentService.calculateAverageGrade("1");
        Mockito.verify(studentRepository).getAverageGrade("1");
    }

    @ParameterizedTest
    @NullAndEmptySource
//Задать вопрос: нужно ли в названии теста прописывать EmptyAndNullArgs
// или аннотации достаточно
    void calculateAverageGradeTestEmptyAndNullArgs(String studentId) {
        Assertions.assertThrows(NullPointerException.class,
                () -> studentService.calculateAverageGrade(studentId));
    }

    @Test
    void getStudentsWithGradesTestAboveVerify() {
        studentService.getStudentsWithGradesAbove(3);
        Mockito.verify(studentRepository).getStudentsWithGradesAbove(3);
    }

    @Test
    void getStudentsWithGradesAboveTestNegative() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> studentService.getStudentsWithGradesAbove(-2));
    }

    @Test
    void getTopPerformingStudentsTestVerify() {
        studentService.getTopPerformingStudents(10);
        Mockito.verify(studentRepository).getTopPerformingStudents(10);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -10})
    void getTopPerformingStudentsTestIAException(int n) {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> studentService.getTopPerformingStudents(n));
    }

    @Test
    void loadStudentsFromFileTestVerify() throws IOException {
        studentService.loadStudentsFromFile("st.txt");
        Mockito.verify(studentRepository).loadStudentsFromFile("st.txt");
    }

    @SneakyThrows
    @ParameterizedTest
    @NullAndEmptySource
    void loadStudentsFromFileTestNPException(String filePath) {
        Assertions.assertThrows(NullPointerException.class,
                () -> studentService.loadStudentsFromFile(filePath));
    }

    @SneakyThrows
    @Test
    void loadCoursesFromFileTestVerify() {
        studentService.loadCoursesFromFile("cou.txt");
        Mockito.verify(studentRepository).loadCoursesFromFile("cou.txt");
    }

    @ParameterizedTest
    @NullAndEmptySource
    void loadCoursesFromFileTestIAException(String filePath) {
        Assertions.assertThrows(NullPointerException.class,
                () -> studentService.loadCoursesFromFile(filePath));
    }
}