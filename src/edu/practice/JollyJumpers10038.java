package edu.practice;

import java.util.HashMap;
import java.util.Scanner;

public class JollyJumpers10038 {

    private static class TwoNums {
        int num1;
        int num2;

        public TwoNums(int n1, int n2) {
            this.num1 = n1;
            this.num2 = n2;
        }

        public void append(int num) {
            this.num1 = this.num2;
            this.num2 = num;
        }

        public int getAbsDiff() {
            return Math.abs(this.num1 - this.num2);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // while loop for each input line
        while (scan.hasNextLine()) {
            // Number of input numbers to check if jolly
            int n = scan.nextInt();
            if (n <= 1) {
                System.out.println("Jolly");
                scan.nextLine();
                continue;
            }

            HashMap<Integer, Boolean> hm = new HashMap<>(n);
            TwoNums numStore = new TwoNums(0, scan.nextInt());
            boolean canBeJolly = true;

            for (int i = 1; i < n; i++) {
                numStore.append(scan.nextInt());
                int diff = numStore.getAbsDiff();

                if (diff < n) {
                    if (hm.put(diff, true) != null) {
                        System.out.println("Not jolly");
                        if (i + 1 < n) {
                            scan.nextLine();
                        }
                        canBeJolly = false;
                        break;
                    }
                } else {
                    System.out.println("Not jolly");
                    if (i + 1 < n) {
                        scan.nextLine();
                    }
                    canBeJolly = false;
                    break;
                }
            }

            if (canBeJolly) {
                System.out.println("Jolly");
            }
        }
    }
}
