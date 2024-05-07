package org.example._2024_04_09;

public class PersonComparisonTest {
    public static void main(String[] args) {
        Person person1 = new Person("NIK", "SNIK", 1, 1234.45);
        Person person2 = new Person("PER2", "SPer2", 122, 12234.45);

        System.out.println(person1.equals(person2));

        System.out.println(person1.hashCode());
        System.out.println(person2.hashCode());
    }
}
