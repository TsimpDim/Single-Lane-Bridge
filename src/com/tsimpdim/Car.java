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

        if(Bridge.lock.isLocked())
            System.out.println(name + " is waiting to cross the bridge");

        // While someone is crossing the bridge
        // Or you're a blue car and a red one hasn't crossed (assuming there are red cars remaining)
        // Or you're a red car and a red one *has* crossed (assuming there are blue cars remaining)
        // Then wait for your turn
        while(Bridge.lock.isLocked() ||
                (this instanceof BlueCar && (!bridge.hasRedCarCrossed() && RedCar.redCars > 0)) ||
                (this instanceof RedCar && (bridge.hasRedCarCrossed() && BlueCar.blueCars > 0))){
        }

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
            if (this instanceof RedCar) {
                bridge.setRedCarCrossed(true);

                if (BlueCar.blueCars > 0)
                    System.out.println("-BlueCar time-");
                else if (BlueCar.blueCars == 0 && RedCar.redCars > 0)
                    System.out.println("-No more BlueCars remaining -> RedCar time");
                else
                    System.out.println("<End>");
            } else {
                bridge.setRedCarCrossed(false);

                if (RedCar.redCars > 0)
                    System.out.println("-RedCar time-");
                else if (RedCar.redCars == 0 && BlueCar.blueCars > 0)
                    System.out.println("-No more RedCars remaining -> BlueCar time");
                else
                    System.out.println("<End>");
            }

        }finally {
            Bridge.lock.unlock();
        }
    }
}
