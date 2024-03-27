package org.example._2024_03_27;

public class Manager extends Employee {
    private int subordinatesCount;

    public Manager(String name, String position, double salary, int subordinatesCount) {
        super(name, position, salary);
        this.subordinatesCount = subordinatesCount;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Subordinates Count: " + subordinatesCount;
    }

    @Override
    public double calculateBonus() {
        return super.calculateBonus() + (subordinatesCount * 0.02 * super.getSalary());
    }
}
