package com.tsimpdim;

public class Main {

    public static void main(String[] args) {

        int redCarPop = 0;
        int blueCarPop = 0;
        int freq = 0;
        int waitTime = 0;

        if(args.length != 4) {
            System.out.println("Usage: <amount of red cars> <amount of blue cars> <frequency of arrival> <wait time>");
            System.exit(1);
        }

        try{

            redCarPop = Integer.parseInt(args[0]);
            blueCarPop = Integer.parseInt(args[1]);
            freq = Integer.parseInt(args[2]);
            waitTime = Integer.parseInt(args[3]);

        }catch(NumberFormatException e){

            System.out.println("Invalid argument format.");
            System.exit(1);

        }

        Bridge mainBridge = new Bridge();
        Car[] cars = new Car[redCarPop + blueCarPop];

        // Fill array
        for(int i = 0; i < redCarPop; i++)
            cars[i] = new RedCar(mainBridge, waitTime);

        for(int i = redCarPop; i < cars.length; i++)
            cars[i] = new BlueCar(mainBridge, waitTime);

        // Start cars
        for(int i = 0; i < cars.length; i++) {
            cars[i].start();

            // Control frequency
            try {
                Thread.sleep(freq);
            }catch (InterruptedException e){}
        }
    }
}
