package com.tsimpdim;

public class RedCar extends Car{

    private static int idx = 1; // Index is given automatically and separately for Red & Blue cars
    protected static int redCars; // <Protected> for access in the superclass

    public RedCar(Bridge bridge, int waitTime, int redCars){
        super("RedCar" + idx, waitTime, bridge);
        this.redCars = redCars;

        idx++;
    }

    @Override
    public int reducePop(){
        if(redCars <= 0)
            return -1;

        return --redCars;
    }
}
