package com.tsimpdim;

public abstract class Car extends Thread{
    private String name;
    private Bridge bridge;
    private int waitTime; // Time it takes to cross the bridge

    public Car(String carName, int waitTime, Bridge bridge){
        this.name = carName;
        this.waitTime = waitTime;
        this.bridge = bridge;
    }

    public abstract int reducePop();

    @Override
    public void run() {

        if(bridge.isBeingCrossed())
            System.out.println(name + " is waiting to cross the bridge");

        // While someone is crossing the bridge
        // Or you're a blue car and a red one hasn't crossed (assuming there are red cars remaining)
        // Or you're a red car and a red one *has* crossed (assuming there are blue cars remaining)
        // Then wait for your turn
        while(bridge.isBeingCrossed() ||
                (this instanceof BlueCar && (!bridge.hasRedCarCrossed() && RedCar.redCars > 0)) ||
                (this instanceof RedCar && (bridge.hasRedCarCrossed() && BlueCar.blueCars > 0))){
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

        this.reducePop();
        if(this instanceof RedCar){
            bridge.setRedCarCrossed(true);
            System.out.println("-BlueCar time-");
        }else{
            bridge.setRedCarCrossed(false);
            System.out.println("-RedCar time-");
        }


        bridge.unlock();
    }
}
