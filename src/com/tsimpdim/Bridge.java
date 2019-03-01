package com.tsimpdim;


import java.util.concurrent.locks.ReentrantLock;

public class Bridge {


    public static ReentrantLock lock;
    private Car[] cars;

    public Bridge(Car[] cars){
        super();

        lock = new ReentrantLock();
        this.cars = cars;
    }

    public void calcWeights(){

        // Get number of cars that haven't crossed yet
        int remainingRed = 0;
        int remainingBlue = 0;
        int remainingTotal;

        for(int i = 0; i < cars.length; i++)
            if(cars[i] instanceof RedCar && !cars[i].isCrossed())
                remainingRed++;
            else if(cars[i] instanceof BlueCar && !cars[i].isCrossed())
                remainingBlue++;

        remainingTotal = remainingBlue + remainingRed;

        // Calculate weights
        int redWeight = (int)(((double) remainingRed/(remainingTotal)) * 10);
        int blueWeight = 10 - redWeight;

        // Make 0s into 1s, since minimum priority is 1
        if(redWeight == 0) redWeight = 1;
        if(blueWeight == 0) blueWeight = 1;

        System.out.println("RedWeight -> " + redWeight);
        System.out.println("BlueWeight -> " + blueWeight);

        // Set priorities
        for(int i = 0; i < cars.length; i++)
            if(cars[i] instanceof RedCar)
                cars[i].setPriority(redWeight);
            else
                cars[i].setPriority(blueWeight);
    }
}
