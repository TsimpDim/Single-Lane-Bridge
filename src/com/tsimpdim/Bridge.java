package com.tsimpdim;


public class Bridge {


    private boolean beingCrossed; // Used to prevent many cars from crossing at once. <!> This is not used in the first scenario
    private boolean redCarCrossed; // Used to alternate between red and blue cars

    public Bridge(){
        super();


        beingCrossed = false;
        redCarCrossed = false;
    }

    // Allow cars to cross bridge
    public void unlock(){
        beingCrossed = false;
    }

    // Disallow cars to cross bridge
    public void lock(){
        beingCrossed = true;
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
