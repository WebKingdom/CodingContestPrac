package edu.practice;

import java.util.Scanner;

public class LoveCalc10424 {

    private static int calcSum(String name) {
        int sum = 0;

        for (int i = 0; i < name.length(); i++) {
            int charVal = name.charAt(i);

            if (charVal >= 97 && charVal <= 122) {
                sum += charVal - 96;
            }
        }
        return sum;
    }

    private static int calcSumAdd(int num) {
        int sum;

        do {
            sum = 0;
            String numStr = Integer.toString(num);

            for (int i = 0; i < numStr.length(); i++) {
                int charVal = numStr.charAt(i);

                if (charVal >= 48 && charVal <= 57) {
                    sum += charVal - 48;
                }
            }
            num = sum;
        } while (sum >= 10);
        return sum;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (scan.hasNextLine()) {
            String name1 = scan.nextLine().toLowerCase();
            int sum1 = calcSum(name1);
            String name2 = scan.nextLine().toLowerCase();
            int sum2 = calcSum(name2);

            double sumAdd1 = calcSumAdd(sum1);
            double sumAdd2 = calcSumAdd(sum2);

            if (sumAdd1 <= sumAdd2) {
                System.out.printf("%.2f %s\n", (sumAdd1 / sumAdd2) * 100.0, "%");
            } else {
                System.out.printf("%.2f %s\n", (sumAdd2 / sumAdd1) * 100.0, "%");
            }
        }
    }
}
