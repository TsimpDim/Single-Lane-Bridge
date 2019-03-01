package com.tsimpdim;

import java.util.concurrent.locks.ReentrantLock;

public class BlueCar extends Car{

    private static int idx = 1; // Index is given automatically and separately for Red & Blue cars

    public BlueCar(ReentrantLock lock, int waitTime){
        super("BlueCar" + idx, waitTime, lock);

        idx++;
    }
}
