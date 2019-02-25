package com.tsimpdim;

public class Main {

    public static void main(String[] args) {

        Bridge mainBridge = new Bridge();
        RedCar[] redCars = new RedCar[5];
        BlueCar[] blueCars = new BlueCar[2];

        for(int i = 0; i < redCars.length; i++)
            redCars[i] = new RedCar(mainBridge);

        for(int i = 0; i < blueCars.length; i++)
            blueCars[i] = new BlueCar(mainBridge);

        for(int i = 0; i < Math.max(redCars.length, blueCars.length); i++){
            if(i < redCars.length)
                redCars[i].start();

            if(i < blueCars.length)
                blueCars[i].start();
        }
    }
}
