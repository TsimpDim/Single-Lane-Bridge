package com.tsimpdim;

import java.util.LinkedList;
import java.util.Queue;

public class Bridge {

    // Important use of `Queue` to hold the cars in each side
    private Queue<Car> leftSide;
    private Queue<Car> rightSide;
    private boolean beingCrossed; // Used to prevent many cars from crossing at once. <!> This is not used in the first scenario


    public Bridge(){
        super();
        leftSide = new LinkedList<>(); // <!>This implementation by itself is not thread safe
        rightSide = new LinkedList<>();

        beingCrossed = false;
    }


    // Left side is RedCars only
    public void addLeft(RedCar car){
        leftSide.add(car);
    }

    // Right side is BlueCars only
    public void addRight(BlueCar car){
        rightSide.add(car);
    }

    // Allow cars to cross bridge
    public void unlock(){
        beingCrossed = false;
    }

    // Disallow cars to cross bridge
    public void lock(){
        beingCrossed = true;
    }

    public boolean isBeingCrossed() {
        return beingCrossed;
    }

    // Pop from left side
    public void popLeft(){
        leftSide.remove();
    }

    // Pop from right side
    public void popRight(){
        rightSide.remove();
    }
}
