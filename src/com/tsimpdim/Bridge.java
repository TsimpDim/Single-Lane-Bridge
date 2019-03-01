package com.tsimpdim;


import java.util.concurrent.locks.ReentrantLock;

public class Bridge {


    private boolean beingCrossed; // Used to prevent many cars from crossing at once. <!> This is not used in the first scenario
    private boolean redCarCrossed; // Used to alternate between red and blue cars
    public static ReentrantLock lock;

    public Bridge(){
        super();

        lock = new ReentrantLock();
        beingCrossed = false;
        redCarCrossed = false;
    }


    public boolean hasRedCarCrossed() {
        return redCarCrossed;
    }

    public void setRedCarCrossed(boolean redCarCrossed) {
        this.redCarCrossed = redCarCrossed;
    }

    public boolean isBeingCrossed() {
        return beingCrossed;
    }
}
