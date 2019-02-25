package com.tsimpdim;

public class RedCar extends Car{

    private static int idx = 1; // Index is given automatically and separately for Red & Blue cars

    public RedCar(Bridge bridge){
        super("RedCar" + idx, (int)Math.random()*10, bridge);
        idx++;
    }
}
