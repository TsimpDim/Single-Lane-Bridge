package com.tsimpdim;

public class BlueCar extends Car{

    private static int idx = 1; // Index is given automatically and separately for Red & Blue cars

    public BlueCar(Bridge bridge){
        super("BlueCar" + idx, 200, bridge);


        idx++;
    }
}
