package org.example._2024_04_09;

public class IntegerCreationAndComparison {
    public static void main(String[] args) {
        Integer i1 = 5;
        Integer i2 = new Integer(5);

        System.out.println(i1.equals(i2));
        System.out.println(i1 == i2);
    }
}
