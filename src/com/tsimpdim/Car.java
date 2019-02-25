package com.tsimpdim;

public abstract class Car extends Thread{
    private String name;
    private String colour;
    private Bridge bridge;
    private int waitTime; // Time it takes to cross the bridge

    public Car(String carName, String colour, int waitTime, Bridge bridge){
        this.name = carName;
        this.colour = colour;
        this.waitTime = waitTime;
        this.bridge = bridge;
    }

    // Removes car from the problem
    // Implementation changes with car type
    abstract void carQuit();

    public Bridge getBridge() {
        return bridge;
    }

    @Override
    public void run() {

        if(bridge.isBeingCrossed())
            System.out.println(name + " is waiting to cross the bridge");

        while(bridge.isBeingCrossed()){
            try{
                Thread.sleep(5);
            } catch (InterruptedException e) {}
        }

        // After the other car is done crossing the bridge, cross it yourself
        bridge.lock();

        System.out.println(name + " is crossing the bridge");

        // Sleep for <waitTime> for slower execution
        try{
            Thread.sleep(waitTime);
        } catch (InterruptedException e) {}

        System.out.println(name + " crossed the bridge");

        bridge.unlock();
    }
}
