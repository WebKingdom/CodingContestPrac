package edu.practice;

public class MainTesting {

    public static void main(String[] args) {
        for (int i = 2; i < 10; i++) {
            System.out.println(i);
        }

        System.out.println("++i");

        for (int i = 2; i < 10; ++i) {
            System.out.println(i);
        }
    }
}
