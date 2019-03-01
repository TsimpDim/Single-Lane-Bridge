package com.tsimpdim;

import java.util.Arrays;
import java.util.Random;

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


        Car[] cars = new Car[redCarPop + blueCarPop];
        Bridge mainBridge = new Bridge(cars);

        // Fill array
        for(int i = 0; i < redCarPop; i++)
            cars[i] = new RedCar(mainBridge, waitTime, redCarPop);

        for(int i = redCarPop; i < cars.length; i++)
            cars[i] = new BlueCar(mainBridge, waitTime, blueCarPop);

        mainBridge.calcWeights();

        // We shuffle the array so the order of arrival is not always the same
        shuffleArray(cars);
        System.out.println(Arrays.toString(cars));

        // Start cars
        for(int i = 0; i < cars.length; i++) {
            cars[i].start();

            // Control frequency
            try {
                Thread.sleep(freq);
            }catch (InterruptedException e){}
        }
    }

    // From https://stackoverflow.com/a/18456998
    private static void shuffleArray(Car[] array)
    {
        int index;
        Car temp;
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--)
        {
            index = random.nextInt(i + 1);
            temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }
}
