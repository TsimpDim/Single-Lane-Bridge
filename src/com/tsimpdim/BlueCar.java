package com.tsimpdim;

public class BlueCar extends Car{

    private static int idx = 1; // Index is given automatically and separately for Red & Blue cars

    public BlueCar(Bridge bridge){
        super("BlueCar" + idx, "Blue", 200, bridge);
        bridge.addRight(this); // Add car automatically to the bridge


        idx++;
    }

    @Override
    public void carQuit(){
        this.getBridge().popRight();
    }
}
