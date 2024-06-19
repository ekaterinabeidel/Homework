package org.example._2024_06_17.mockTask;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Класс StudentRepository
 * Описание: Этот класс управляет данными студентов и курсов.
 * Поля:
 * Map<String, Student> students: хранит студентов по их id.
 * Map<String, Course> courses: хранит курсы по их id.
 * Map<String, Map<String, Integer>> studentCourseGrades: хранит оценки студентов по курсам.
 * Методы:
 * void addStudent(Student student): добавляет нового студента.
 * void addCourse(Course course): добавляет новый курс.
 * void enrollStudentToCourse(String studentId, String courseId): записывает студента на курс.
 * void updateGrade(String studentId, String courseId, int grade): обновляет оценку студента по курсу.
 * Map<String, Integer> getGradesByStudent(String studentId): возвращает оценки студента.
 * double getAverageGrade(String studentId): рассчитывает среднюю оценку студента.
 * List<Student> getStudentsWithGradesAbove(int grade): возвращает список студентов, у которых есть оценки выше указанного значения.
 * List<String> getTopPerformingStudents(int n): возвращает список n студентов с самыми высокими средними оценками.
 * void loadStudentsFromFile(String filePath) throws IOException: загружает студентов из файла.
 * void loadCoursesFromFile(String filePath) throws IOException: загружает курсы из файла.
 */

public class StudentRepository {
    private Map<String, Student> students = new HashMap<>();
    private Map<String, Course> courses = new HashMap<>();
    private Map<String, Map<String, Integer>> studentCourseGrades = new HashMap<>();

    public void addStudent(Student student) {
        students.put(student.id(), student);
        studentCourseGrades.putIfAbsent(student.id(), new HashMap<>());
    }

    public void addCourse(Course course) {
        courses.put(course.id(), course);

    }

    public void enrollStudentToCourse(String studentId, String courseId) {
        Map<String, Integer> courseIdToGrade = studentCourseGrades.get(studentId);
        courseIdToGrade.put(courseId, 0);
    }

    public void updateGrade(String studentId, String courseId, int grade) {
        studentCourseGrades.get(studentId).put(courseId, grade);
    }

    public Map<String, Integer> getGradesByStudent(String studentId) {
        return studentCourseGrades.get(studentId);
    }

    public double getAverageGrade(String studentId) {
        return studentCourseGrades.get(studentId).values().stream()
                .mapToDouble(grade -> grade)
                .average().orElse(0.0);
    }

    //Замена List<Student> на List <String>
    public List<String> getStudentsWithGradesAbove(int grade) {

        return studentCourseGrades.entrySet().stream()
                .filter(studentToCourseToGrade ->
                        studentToCourseToGrade.getValue().values().stream()
                                .anyMatch(g -> g > grade)
                )
                .map(Map.Entry::getKey )
                .collect(Collectors.toList());
    }

    public List<String> getTopPerformingStudents(int n) {
        return studentCourseGrades.keySet().stream()
                .sorted((st1, st2) -> {
                    double averageGrade1 = studentCourseGrades.get(st1).values().stream()
                            .mapToDouble(g -> g)
                            .average().orElse(0.0);
                    double averageGrade2 = studentCourseGrades.get(st2).values().stream()
                            .mapToDouble(g -> g)
                            .average().orElse(0.0);
                    return Double.compare(averageGrade2, averageGrade1);
                })
                .limit(n)
                .collect(Collectors.toList());
    }

    public void loadStudentsFromFile(String filePath) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] substrings = line.split(",");
            String studentId = substrings[0];
            String studentName = substrings[1];
            students.putIfAbsent(studentId, new Student(studentId, studentName));
            studentCourseGrades.putIfAbsent(studentId, new HashMap<>());
        }
    }

    public void loadCoursesFromFile(String filePath) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("cou.txt"));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] substrings = line.split(",");
            String courseId = substrings[0];
            String courseName = substrings[1];
            courses.put(courseId, new Course(courseId, courseName));
        }
    }

    public static void main(String[] args) {
        Student student = new Student("1", "Alex");
        Course course1 = new Course("101", "Math");
        Course course2 = new Course("102", "Physics");
        StudentRepository studentRepository = new StudentRepository();
        studentRepository.addStudent(student);
        studentRepository.enrollStudentToCourse(student.id(), course1.id());
    }
}