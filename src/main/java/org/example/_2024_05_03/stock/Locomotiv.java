package org.example._2024_05_03.stock;

public class Locomotiv {
    private int id;

    public int getId() {
        return id;
    }

    public Locomotiv(int id) {
        this.id = id;
    }
    public void getFirstVagon(RollingStock rollingStock){
        System.out.printf("Locomotiv %d unhooked vagon %d%n", this.id , rollingStock.unhookFirst().getId());
    }
    public void getLarstVagon(RollingStock rollingStock){
        System.out.printf("Locomotiv %d unhooked vagon %d%n", this.id , rollingStock.unhookLast().getId());
    }
}
