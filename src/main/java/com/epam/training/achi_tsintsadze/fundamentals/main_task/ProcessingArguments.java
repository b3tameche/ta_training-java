package com.epam.training.achi_tsintsadze.fundamentals.main_task;

public class ProcessingArguments {
    public static void main(String[] args) {
        int sum = 0;

        for(String each : args) {
            sum += Integer.parseInt(each);
        }
        System.out.println(sum);
    }
}
