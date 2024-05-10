package org.example._2024_05_03.iceCreamCone;

public class Main {
    public static void main(String[] args) {
        IceCreamBall ball1 = new IceCreamBall("Vanilla");
        IceCreamBall ball2 = new IceCreamBall("Strawberry");
        IceCreamBall ball3 = new IceCreamBall("Mango");

        IceCreamCone cone = new IceCreamCone();
        cone.putBall(ball1);
        cone.putBall(ball2);
        cone.putBall(ball3);

        Taster taster = new Taster();
        taster.taste(cone);

    }
}
