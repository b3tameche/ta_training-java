package com.epam.training.achi_tsintsadze.fundamentals.main_task;

public class ReverseOrder {
    public static void main(String[] args) {
        for (int i = args.length - 1; i >= 0; i--) {
            System.out.print(args[i] + " ");
        }
    }
}
