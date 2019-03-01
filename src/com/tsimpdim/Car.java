package com.tsimpdim;

public abstract class Car extends Thread{
    private String name;
    private Bridge bridge;
    private int waitTime; // Time it takes to cross the bridge
    private boolean crossed;

    public Car(String carName, int waitTime, Bridge bridge){
        this.name = carName;
        this.waitTime = waitTime;
        this.bridge = bridge;
        crossed = false;
    }

    public abstract int reducePop();

    public boolean isCrossed() {
        return crossed;
    }


    @Override
    public void run() {

        if(Bridge.lock.isLocked())
            System.out.println(name + " is waiting to cross the bridge");


        // After the other car is done crossing the bridge, cross it yourself
        Bridge.lock.lock();
        try {
            System.out.println(name + " is crossing the bridge");

            // Sleep for <waitTime> for slower execution
            try {
                Thread.sleep(waitTime);
            } catch (InterruptedException e) {
            }

            System.out.println(name + " crossed the bridge");
            this.reducePop();
            this.crossed = true;
        }finally {
            bridge.calcWeights();
            Bridge.lock.unlock();
        }
    }

    @Override
    public String toString(){
        return name;
    }

}
