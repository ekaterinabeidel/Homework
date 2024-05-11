package org.example.hauseCollectionTasksForReview.taski.t1andt2;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Course> courseList = new LinkedList<>();
        Student einstein = new Student("Альберт", "Эйнштейн", 25);
        Student newton = new Student("Исаак", "Ньютон", 25);
        Student curie1 = new Student("Мария", "Кюри", 30);
        Student curie2 = new Student("Пьер", "Кюри", 38);
        Student curie3 = new Student("Мария", "Склодовская", 20);
        Student curie4 = new Student("Пьер", "Кюри", 28);
        Course physicsCourse = new Course("Физика");
        Course chemistryCourse = new Course("Химия");
        physicsCourse.addStudentToCourse(einstein);
        physicsCourse.addStudentToCourse(newton);
        chemistryCourse.addStudentToCourse(curie1);
        chemistryCourse.addStudentToCourse(curie2);
        chemistryCourse.addStudentToCourse(curie3);
        chemistryCourse.addStudentToCourse(curie4);
        einstein.addCourseToStudentCourseEnrollmentsList(physicsCourse);
        newton.addCourseToStudentCourseEnrollmentsList(physicsCourse);
        curie1.addCourseToStudentCourseEnrollmentsList(chemistryCourse);
        curie2.addCourseToStudentCourseEnrollmentsList(chemistryCourse);
        curie3.addCourseToStudentCourseEnrollmentsList(chemistryCourse);
        curie4.addCourseToStudentCourseEnrollmentsList(chemistryCourse);
        System.out.println("\nСтуденты на курсе Физика:");
        for (Student student : physicsCourse.getAllStudentsEnrolledInCourse(physicsCourse.getCourseTitle())) {
            System.out.println(student.getStudentSurname() + " " + student.getStudentName());
        }
        System.out.println("\nСтуденты на курсе Химия:");
        for (Student student : chemistryCourse.getAllStudentsEnrolledInCourse(chemistryCourse.getCourseTitle())) {
            System.out.println(student.getStudentSurname() + " " + student.getStudentName());
        }
        System.out.println("\nКурсы для студента Эйнштейн:");
        List<Course> coursesForEinsteinByName = einstein.getAllCoursesForStudentBySurname("Эйнштейн");
        for (Course course : coursesForEinsteinByName) {
            System.out.println(course.getCourseTitle());
        }
        System.out.println("\nКурсы для студента Мария:");
        List<Course> coursesForCurieBySurname = curie1.getAllCoursesForStudentByName("Мария");
        for (Course course : coursesForCurieBySurname) {
            System.out.println(course.getCourseTitle());
            System.out.println("\nСредний возраст студентов на курсе Физика: " + physicsCourse.averageStudentAgeForCourse(physicsCourse.getCourseTitle()));
            System.out.println("\nСредний возраст студентов на курсе Химия: " + chemistryCourse.averageStudentAgeForCourse(chemistryCourse.getCourseTitle()));
        }
        System.out.println("\n-------------------------------t2---------------------------------------------");
        List<Student> students = new ArrayList<>();
        students.add(einstein);
        students.add(newton);
        students.add(curie1);
        students.add(curie2);
        students.add(curie3);
        students.add(curie4);
        System.out.println("\nДо сортировки:");
        for (Student student : students) {
            System.out.println(student.toString());
        }
        Collections.sort(students);
        System.out.println("\nПосле сортировки по возрасту:");
        for (Student student : students) {
            System.out.println(student);
        }
        Comparator<Student> surnameComparator = Comparator.comparing(Student::getStudentSurname);
        students.sort(surnameComparator);
        System.out.println("\nОтсортированный список студентов по фамилии:");
        for (Student student : students) {
            System.out.println(student);
        }
        Comparator<Student> nameComparator = Comparator.comparing(Student::getStudentName);
        students.sort(nameComparator);
        System.out.println("\nОтсортированный список студентов по имени:");
        for (Student student : students) {
            System.out.println(student);
        }
        Comparator<Student> ageNameComparator = Comparator.comparing(Student::getStudentAge)
                .thenComparing(Student::getStudentName);
        students.sort(ageNameComparator);
        System.out.println("\nОтсортированный список студентов сначала по возрасту, а затем по имени:");
        for (Student student : students) {
            System.out.println(student);
        }
        Comparator<Student> multiLevelComparator = Comparator.comparing(Student::getStudentSurname)
                .thenComparing(Student::getStudentName)
                .thenComparing(Student::getStudentAge);
        students.sort(multiLevelComparator);
        System.out.println("\nОтсортированный список студентов сначала по фамилии, затем по имени, а затем по возрасту:");
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println("\nГруппы сортируются по названию, а студенты внутри каждой группы сортируются по возрасту.");
        List<Group> groups = new ArrayList<>();
        Group nobelPrizeGroup = new Group("Имеют Нобелевскую премию");
        nobelPrizeGroup.addStudent(einstein);
        nobelPrizeGroup.addStudent(curie1);
        nobelPrizeGroup.addStudent(curie2);
        nobelPrizeGroup.addStudent(curie3);
        nobelPrizeGroup.addStudent(curie4);
        groups.add(nobelPrizeGroup);
        Group noNobelPrizeGroup = new Group("Не имеют Нобелевской премии");
        noNobelPrizeGroup.addStudent(newton);
        groups.add(noNobelPrizeGroup);
        groups.sort(Comparator.comparing(Group::getGroupName));
        for (Group group : groups) {
            System.out.println("\nГруппа: " + group.getGroupName());
            group.getListOfStudentsToGroup().sort(Comparator.comparing(Student::getStudentAge));
            for (Student student : group.getListOfStudentsToGroup()) {
                System.out.println(student);
            }
            System.out.println();
        }

    }
}