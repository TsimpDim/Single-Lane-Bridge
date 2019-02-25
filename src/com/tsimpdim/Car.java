package com.tsimpdim;

public class Car extends Thread{
    private String name;
    private Bridge bridge;
    private long waitTime; // Time it takes to cross the bridge

    public Car(String carName, Bridge bridge){
        this.name = carName;
        this.waitTime = (long) (Math.random() * 50 + Math.random());
        this.bridge = bridge;
    }

    public long getWaitTime() {
        return waitTime;
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

        System.out.println(name + " is crossing the bridge[" + getWaitTime() + "ms]");

        // Sleep for <waitTime> for slower execution
        try{
            Thread.sleep(waitTime);
        } catch (InterruptedException e) {}

        System.out.println(name + " crossed the bridge");

        bridge.unlock();
    }
}
