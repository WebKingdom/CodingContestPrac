package edu.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EventPlanning11559 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = 0, B = 0, H = 0, W = 0;
        int p = 0, a = 0;

        try {
            while (true) {
                String[] line1 = br.readLine().split(" ");

                N = Integer.parseInt(line1[0]);
                B = Integer.parseInt(line1[1]);
                H = Integer.parseInt(line1[2]);
                W = Integer.parseInt(line1[3]);

                int cheapestPrice = B + 1;

                for (int i = 0; i < H; i++) {
                    // price per person for weekend
                    p = Integer.parseInt(br.readLine());

                    String[] lineNumBeds = br.readLine().split(" ");
                    for (int j = 0; j < W; j++) {
                        // number of available beds
                        a = Integer.parseInt(lineNumBeds[j]);

                        if (a >= N) {
                            // calculate price with available beds
                            int priceTotal = N * p;

                            if (priceTotal <= B && priceTotal < cheapestPrice) {
                                cheapestPrice = priceTotal;
                            }
                        }
                    }
                }

                if (cheapestPrice == B + 1) {
                    System.out.println("stay home");
                } else {
                    System.out.println(cheapestPrice);
                }
            }
        } catch (Exception e) {
            // done
        }
    }
}
