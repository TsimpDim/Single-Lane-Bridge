package com.tsimpdim;

public class Main {

    public static void main(String[] args) {

        int redCarPop = 5;
        int blueCarPop = 3;
        int freq = 400;
        int waitTime = 550;
        int carsAtATime = 1;

        if(args.length == 0){
            System.out.println("Using default values");
        }else{
            try{

                redCarPop = Integer.parseInt(args[0]);
                blueCarPop = Integer.parseInt(args[1]);
                freq = Integer.parseInt(args[2]);
                waitTime = Integer.parseInt(args[3]);
                carsAtATime = Integer.parseInt(args[4]);

            }catch(NumberFormatException e){

                System.out.println("Invalid argument format");
                System.exit(0);

            }
        }

        Bridge mainBridge = new Bridge();
        Car[] cars = new Car[redCarPop + blueCarPop];

        // Fill array
        for(int i = 0; i < redCarPop; i++)
            cars[i] = new RedCar(mainBridge, waitTime, redCarPop);

        for(int i = redCarPop; i < cars.length; i++)
            cars[i] = new BlueCar(mainBridge, waitTime, blueCarPop);

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
