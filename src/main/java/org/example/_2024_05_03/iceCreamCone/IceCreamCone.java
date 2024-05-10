package org.example._2024_05_03.iceCreamCone;

import java.util.Stack;

public class IceCreamCone {
    private Stack<IceCreamBall> iceCreamBalls;

    public void putBall(IceCreamBall iceCreamBall) {
        iceCreamBalls.add(iceCreamBall);
    }

    public IceCreamBall takeIceCreamBall() {
        return iceCreamBalls.pop();
    }

    public boolean isEmpty(){
        return iceCreamBalls.isEmpty();
    }

    public IceCreamCone() {
        iceCreamBalls = new Stack<>();
    }
}
