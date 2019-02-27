package com.tsimpdim;

public class RedCar extends Car{

    private static int idx = 1; // Index is given automatically and separately for Red & Blue cars

    public RedCar(Bridge bridge, int waitTime){
        super("RedCar" + idx, waitTime, bridge);

        idx++;
    }
}
