package com.tsimpdim;

public class BlueCar extends Car{

    private static int idx = 1; // Index is given automatically and separately for Red & Blue cars
    protected static int blueCars;


    public BlueCar(Bridge bridge, int waitTime, int blueCars){
        super("BlueCar" + idx, waitTime, bridge);
        this.blueCars = blueCars;

        idx++;
    }

    @Override
    public int reducePop(){
        if(blueCars <= 0)
            return -1;

        return --blueCars;
    }
}
