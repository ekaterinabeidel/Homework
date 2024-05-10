package org.example._2024_05_03.iceCreamCone;

public class Taster {
    public void taste(IceCreamCone cone) {
        while (!cone.isEmpty()) {
           IceCreamBall ball = cone.takeIceCreamBall();
            System.out.println("I tasted " + ball.getTaste());
        }
    }
}
