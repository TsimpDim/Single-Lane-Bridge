package com.tsimpdim;

public class Car extends Thread{
    private String name;
    private Bridge bridge;
    private int waitTime; // Time it takes to cross the bridge

    public Car(String carName, int waitTime, Bridge bridge){
        this.name = carName;
        this.waitTime = waitTime;
        this.bridge = bridge;
    }

    @Override
    public void run() {


        if(bridge.isBeingCrossed())
            System.out.println("<!> Collision is about to happen");

        bridge.lock(); // Lock here doesn't actually do anything other than notify the bridge that a car is crossing

        System.out.println(name + " is crossing the bridge");

        // Sleep for <waitTime> for slower execution
        try{
            Thread.sleep(waitTime);
        } catch (InterruptedException e) {}

        System.out.println(name + " crossed the bridge");

        bridge.unlock();

    }
}
