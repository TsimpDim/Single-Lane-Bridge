package com.tsimpdim;


public class Bridge {


    private boolean beingCrossed; // Used to prevent many cars from crossing at once. <!> This is not used in the first scenario
    private boolean redCarCrossed; // Used to alternate between red and blue cars
    private double weightOfSides; // Used to weigh which of the sides (red/blue) needs to go first for maximum efficiency. > 0 = blue priority | < 0 = red priority;

    public Bridge(int redCarPop, int blueCarPop){
        super();


        beingCrossed = false;
        redCarCrossed = false;

        double redWeight = (double) redCarPop/(redCarPop+blueCarPop);
        double blueWeight = (double) blueCarPop/(redCarPop+blueCarPop);
        weightOfSides = blueWeight - redWeight;
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
