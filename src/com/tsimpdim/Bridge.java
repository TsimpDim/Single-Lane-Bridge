package com.tsimpdim;

public class Bridge {

    private boolean beingCrossed; // Used to prevent many cars from crossing at once. <!> This is not used in the first scenario


    public Bridge(){
        super();
        beingCrossed = false;
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
}
