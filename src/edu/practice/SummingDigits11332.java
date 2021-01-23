package edu.practice;

import java.util.Scanner;

public class SummingDigits11332 {

    private static int sumDigits(int num) {
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

        int curNum = scan.nextInt();
        while (curNum != 0) {
            System.out.println(sumDigits(curNum));
            curNum = scan.nextInt();
        }
    }
}
