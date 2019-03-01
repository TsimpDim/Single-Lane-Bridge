package com.tsimpdim;

import java.util.concurrent.locks.ReentrantLock;

public class RedCar extends Car{

    private static int idx = 1; // Index is given automatically and separately for Red & Blue cars

    public RedCar(ReentrantLock lock, int waitTime){
        super("RedCar" + idx, waitTime, lock);

        idx++;
    }
}
