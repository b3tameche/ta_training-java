package com.epam.training.achi_tsintsadze.threads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

public class Place implements Runnable {
    private ArrayBlockingQueue<Car> queue;
    private int currentHoldTime = 0; // roughly calculated elapsed time from thread start

    public Place(ArrayBlockingQueue<Car> queue) {
        this.queue = queue;
    }

    public synchronized void run() {
        try {
            while (queue.size() > 0) { // while there are at least 1 car in the queue
                // remove first car from queue and print on which place it is being parked
                System.out.println(queue.take().toString() + "parked on " + Thread.currentThread().getName());

                // check for cars with filled up patience and remove them
                for (Car car : queue) {
                    if (currentHoldTime > car.getPatience()) {
                        queue.remove(car);
                        System.out.println(car.toString() + " left");
                    }
                }


                int holdTime = ThreadLocalRandom.current().nextInt(3000,5000);
                currentHoldTime += holdTime; // update elapsed time
                Thread.sleep(holdTime); // suspends thread to imitate car parking
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

