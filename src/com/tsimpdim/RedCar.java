package com.tsimpdim;

public class RedCar extends Car{

    private static int idx = 1; // Index is given automatically and separately for Red & Blue cars

    public RedCar(Bridge bridge){
        super("RedCar" + idx, "Red", 200, bridge);
        bridge.addLeft(this); // Add car automatically to the bridge

        idx++;
    }

    @Override
    public void carQuit(){
        this.getBridge().popLeft();
    }
}
