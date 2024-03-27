package org.example._2024_03_27;

public class Developer extends Manager {
    public final String programmingLanguage;

    public Developer(String name, String position, double salary, int subordinatesCount, String programmingLanguage) {
        super(name, position, salary, subordinatesCount);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Programming Language: " + programmingLanguage;
    }

    @Override
    public double calculateBonus() {
        return super.calculateBonus() + 500;
    }
}