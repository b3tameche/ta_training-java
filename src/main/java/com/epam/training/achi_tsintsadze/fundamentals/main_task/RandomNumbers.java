package com.epam.training.achi_tsintsadze.fundamentals.main_task;

import java.util.Random;

// If I get it right, I should print random numbers for "given number" of times;
public class RandomNumbers {
    public static void main(String[] args) {
        Random randomGenerator = new Random();

        int givenNumber = Integer.parseInt(args[0]);
        int[] result = new int[givenNumber];

        for (int i = 0; i < givenNumber; i++) {
            result[i] = randomGenerator.nextInt(100); // 100 is optional
        }

        for (int i = 0; i < givenNumber; i++) {
            System.out.print(result[i] + " "); // without a newline break, on a single line
        }

        System.out.println();
        for (int i = 0; i < givenNumber; i++) {
            System.out.print(result[i] + "\n"); // with a newline break character, could be done with "println"
        }
    }
}
