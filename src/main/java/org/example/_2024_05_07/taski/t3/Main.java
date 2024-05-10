package org.example._2024_05_07.taski.t3;

public class Main {
    public static void main(String[] args) {

        Person billGates = new Person("Bill", "Gates", 66);
        Student elonMusk = new Student("Elon", "Musk", 50, "314159");

        System.out.println(billGates);
        System.out.println(elonMusk);

        System.out.println("\nВывод строки с идентификационной информацией студента:");
        System.out.println(elonMusk.getIdentity());

        Person[] people = new Person[2];
        people[0] = new Person("Тим", "Кук", 60);
        people[1] = new Student("Марк", "Цукерберг", 37, "271828");
        for (Person person : people) {
            System.out.println(person.describe());
        }
        Student student = new Student("Линус", "Торвальдс", 52, "73");
        System.out.println("\nВывод идентификационной информации и статуса участия в сообществе:");
        System.out.println(student.getIdentity());
        System.out.println(student.getCommunityStatus());

        Person[] people2 = new Person[4];
        people2[0] = new Student("Ада", "Лавлейс", 25, "011238132134");
        people2[1] = new Student("Деннис", "Ритчи", 23, "11251442132");
        people2[2] = new Teacher("Грейс", "Хоппер", 45, "Компьютерные науки");
        people2[3] = new Teacher("Дональд", "Кнут", 50, "Алгоритмы");

        System.out.println("\nИнформация о студентах и учителях:");
        for (Person person : people2) {
            System.out.println(person.describe());
            if (person instanceof CommunityMember) {
                CommunityMember communityMember = (CommunityMember) person;
                System.out.println(communityMember.getCommunityStatus());
            } else {
                System.out.println("Статус участия в сообществе не доступен.");
            }
        }


    }
}
