package edu.practice;

import java.util.Scanner;

public class Score1585 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numTestCases = scan.nextInt();

        for (int i = 0; i < numTestCases; i++) {
            int score = 0;
            int consecutiveO = 0;

            String testResult = scan.next();

            for (int j = 0; j < testResult.length(); j++) {
                if (testResult.charAt(j) == 'O') {
                    score += 1 + consecutiveO;
                    consecutiveO++;
                } else {
                    consecutiveO = 0;
                }
            }

            System.out.println(score);
        }
    }
}
