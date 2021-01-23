package edu.practice;

import java.util.Scanner;

public class BCardConstruction {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();

        for (int i = 0; i < testCases; i++) {
            long numCardsRemaining = scan.nextLong();
            int numPyramidsBuilt = 0;

            while (numCardsRemaining > 1) {
                int pyramidHeight = (int) ((1.0 / 6.0) * (Math.sqrt((24.0 * numCardsRemaining) + 1.0) - 1.0));
                numCardsRemaining -= (3L * pyramidHeight * pyramidHeight + pyramidHeight) / 2L;
                numPyramidsBuilt++;
            }

            System.out.println(numPyramidsBuilt);
        }
    }
}
