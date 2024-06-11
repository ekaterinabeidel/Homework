package org.example._2024_06_10;

import com.github.javafaker.Faker;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class StudentRegistry {
    static int count_id = 0;
    static Faker faker = new Faker();

    public static Student createStudent() {
        Major[] majors = Major.values();
        return new Student(
                count_id++,
                faker.name().firstName(),
                faker.name().lastName(),
                faker.internet().emailAddress(),
                faker.number().randomDouble(2, 1, 6),
                majors[faker.random().nextInt(majors.length)],
                faker.number().numberBetween(1, 5),
                faker.bool().bool()
        );

    }


    public static Student createStudent(Major major, double grade, int year) {
        return new Student(
                count_id++,
                faker.name().firstName(),
                faker.name().lastName(),
                faker.internet().emailAddress(),
                grade,
                major,
                year,
                faker.bool().bool()
        );
    }


    public static void generateStudents(int total) {
        for (int i = 0; i < total; i++) {
            Student student = createStudent();
            createStudent();
            students.put(student.getId(), student);
        }
    }

    @Getter
    private static Map<Integer, Student> students = new HashMap<>();

    public static void addStudent(Student student) {
        if (students.containsKey(student.getId())) {
            throw new IllegalArgumentException("This student already exists");
        }
        students.put(student.getId(), student);
    }

    public static void removeStudent(int id) {
        if (!students.containsKey(id)) {
            throw new NoSuchElementException("Такого студента не существует");
        }
        students.remove(id);

    }

    public static List<Student> findStudentsByMajor(Major major) {
        return students.values().stream()
                .filter(student -> student.getMajor().equals(major))
                .collect(Collectors.toList());

    }

    public static double calculateAverageGrade() {
        return students.values().stream()
                .mapToDouble(Student::getGrade)
                .average().orElse(0.0);
    }

    public static List<Student> listStudentsByYear(int year) {
        return students.values().stream()
                .filter(student -> student.getYear() == year)
                .collect(Collectors.toList());
    }

    public static Student getStudent(int id) {
        if (!students.containsKey(id)) {
            throw new NoSuchElementException("Такого студента не существует");
        }
        return students.get(id);
    }

    public static int getTotalNumberOfStudents() {
        return students.size();
    }

    public static List<Student> getStudentsWithGradeAbove(double grade) {
        return students.values().stream()
                .filter(student -> student.getGrade() > grade)
                .collect(Collectors.toList());
    }

    public static double getAverageGradeByMajor(Major major) {
        return students.values().stream()
                .filter(student -> student.getMajor().equals(major))
                .mapToDouble(student->student.getGrade())
                .average().orElse(0.0);
    }

    public static boolean isStudentPresent(String email) {
        return students.values().stream()
                .anyMatch(student -> student.getEmail().equals(email));
    }


}
