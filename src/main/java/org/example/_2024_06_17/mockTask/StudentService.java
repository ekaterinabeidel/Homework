package org.example._2024_06_17.mockTask;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Класс StudentService
 * Описание: Этот класс содержит бизнес-логику для работы с данными студентов и курсов.
 * Поля:
 * StudentRepository studentRepository: репозиторий для управления данными.
 * Методы:
 * void registerStudent(Student student): регистрирует нового студента.
 * void enrollStudentToCourse(String studentId, String courseId): записывает студента на курс.
 * void assignGrade(String studentId, String courseId, int grade): присваивает оценку студенту по курсу.
 * Map<String, Integer> getStudentGrades(String studentId): возвращает оценки студента.
 * double calculateAverageGrade(String studentId): рассчитывает среднюю оценку студента.
 * List<Student> getStudentsWithGradesAbove(int grade): возвращает список студентов с оценками выше указанного значения.
 * List<String> getTopPerformingStudents(int n): возвращает список лучших студентов по средним оценкам.
 * void loadStudentsFromFile(String filePath) throws IOException: загружает студентов из файла.
 * void loadCoursesFromFile(String filePath) throws IOException: загружает курсы из файла.
 */
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void registerStudent(Student student) {
        if (student == null) throw new NoSuchElementException("Такого студента не существует");
        studentRepository.addStudent(student);
    }

    public void registerCourse(Course course) {
        if (course == null) {
            throw new NullPointerException("Course cannot be null");
        }
        studentRepository.addCourse(course);
    }

    public void enrollStudentToCourse(String studentId, String courseId) {
        if (studentId == null || studentId.isEmpty()) {
            throw new NullPointerException("Student id cannot be null");
        }
        if (courseId == null || courseId.isEmpty()) {
            throw new NullPointerException("Course id cannot be null");
        }
        studentRepository.enrollStudentToCourse(studentId, courseId);
    }

    public void assignGrade(String studentId, String courseId, int grade) {
        if (studentId == null || studentId.isEmpty()) {
            throw new NullPointerException("Student id cannot be null");
        }
        if (courseId == null || courseId.isEmpty()) {
            throw new NullPointerException("Course id cannot be null");
        }
        if (grade < 0) {
            throw new IllegalArgumentException("Grade cannot be negative");
        }
        studentRepository.updateGrade(studentId, courseId, grade);
    }

    public Map<String, Integer> getStudentGrades(String studentId) {
        if (studentId == null || studentId.isEmpty()) {
            throw new NullPointerException("Student id cannot be null");
        }
        return studentRepository.getGradesByStudent(studentId);
    }

    public double calculateAverageGrade(String studentId) {
        if (studentId == null || studentId.isEmpty()) {
            throw new NullPointerException("Student id cannot be null");
        }
        return studentRepository.getAverageGrade(studentId);
    }

    //Замена List<Student> на List <String>
    public List<String> getStudentsWithGradesAbove(int grade) {
        if (grade < 0) {
            throw new IllegalArgumentException("Grade cannot be negative");
        }
        return studentRepository.getStudentsWithGradesAbove(grade);
    }

    public List<String> getTopPerformingStudents(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Number of students cannot be negative");
        }
        if (n == 0) {
            throw new IllegalArgumentException("Number of students cannot be null");
        }
        return studentRepository.getTopPerformingStudents(n);
    }

    public void loadStudentsFromFile(String filePath) throws IOException {
        if (filePath == null || filePath.isEmpty()) {
            throw new NullPointerException("Path cannot be null or empty");
        }
        studentRepository.loadStudentsFromFile(filePath);
    }

    public void loadCoursesFromFile(String filePath) throws IOException {
        if (filePath == null || filePath.isEmpty()) {
            throw new NullPointerException("Path cannot be null or empty");
        }
        studentRepository.loadCoursesFromFile(filePath);
    }
}