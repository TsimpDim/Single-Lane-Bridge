package com.tsimpdim;

import java.util.concurrent.locks.ReentrantLock;

public class Car extends Thread{
    private String name;
    private int waitTime; // Time it takes to cross the bridge
    private ReentrantLock lock;

    public Car(String carName, int waitTime, ReentrantLock lock){
        this.name = carName;
        this.waitTime = waitTime;
        this.lock = lock;
    }

    @Override
    public void run() {

        if(lock.isLocked())
            System.out.println(name + " is waiting to cross the bridge");

        // After the other car is done crossing the bridge, cross it yourself
        lock.lock();
        try {

            System.out.println(name + " is crossing the bridge");

            // Sleep for <waitTime> for slower execution
            try {
                Thread.sleep(waitTime);
            } catch (InterruptedException e) {
            }

            System.out.println(name + " crossed the bridge");

        }finally{
            lock.unlock();
        }
    }
}
