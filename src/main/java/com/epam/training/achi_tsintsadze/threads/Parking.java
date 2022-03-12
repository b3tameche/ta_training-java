package com.epam.training.achi_tsintsadze.threads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

public class Parking {
    public static void main(String[] args) {
        ArrayBlockingQueue queue = new ArrayBlockingQueue(15); // Actual queue consisting of 15 (optional) cars

        for (int  i = 0; i < 15; i++) { // This loop adds cars with random "Patience" time on the queue
            queue.add(new Car(ThreadLocalRandom.current().nextInt(8000, 15000)));
        }

        Place place1 = new Place(queue);
        Place place2 = new Place(queue);
        Place place3 = new Place(queue);

        new Thread(place1, "Place 1").start(); // Threads below represent parking spaces
        new Thread(place2, "Place 2").start();
        new Thread(place3, "Place 3").start();
    }
}
