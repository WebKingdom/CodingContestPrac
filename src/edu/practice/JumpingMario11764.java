package edu.practice;

import java.util.Scanner;

class JumpingMario11764 {

//    private static int[] calcHighLowJumps(int[] walls) {
//        int[] highLowJumps = new int[2];
//        int curHeight = walls[0];
//
//        for (int i = 1; i < walls.length; i++) {
//            if (walls[i] > curHeight) {
//                highLowJumps[0] += 1;
//            } else if (walls[i] < curHeight) {
//                highLowJumps[1] += 1;
//            }
//            curHeight = walls[i];
//        }
//
//        return highLowJumps;
//    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numTestCases = scan.nextInt();

        for (int i = 1; i <= numTestCases; i++) {
            int numWalls = scan.nextInt();

            if (numWalls <= 0) {
                System.out.println("Case " + i + ": 0 0");
            } else {
                int curHeight = 0, prevHeight = 0;
                int high = 0, low = 0;
                prevHeight = scan.nextInt();

                for (int j = 1; j < numWalls; j++) {
                    curHeight = scan.nextInt();
                    if (curHeight > prevHeight) {
                        high++;
                    } else if (curHeight < prevHeight) {
                        low++;
                    }
                    prevHeight = curHeight;
                }

                System.out.println("Case " + i + ": " + high + " " + low);
            }
        }
    }
}
