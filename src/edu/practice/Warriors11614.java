package edu.practice;

import java.util.Scanner;

public class Warriors11614 {

    private static long computeNumRows(long numWarriors) {
        long rows = (long) Math.sqrt(2 * numWarriors);

        if (((Math.pow(rows, 2) + rows) / 2) < numWarriors ) {
            while (((Math.pow(rows, 2) + rows) / 2) > numWarriors) {
                rows++;
            }
        } else {
            while (((Math.pow(rows, 2) + rows) / 2) > numWarriors) {
                rows--;
            }
        }

        return rows;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long numTests = scan.nextLong();

        for (int i = 0; i < numTests; i++) {
            System.out.println(computeNumRows(scan.nextLong()));
        }
    }
}
