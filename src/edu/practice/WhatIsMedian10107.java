package edu.practice;

import java.util.ArrayList;
import java.util.Scanner;

public class WhatIsMedian10107 {

    // binary search for num in sorted array to find insertion index
    private static int findInsertIndex(ArrayList<Long> l, long num) {
        // set up for binary search, left and right indices
        int len = l.size();
        int lIndex = 0;
        int rIndex = len - 1;

        while (lIndex <= rIndex) {
            // find middle index
            int mIndex = lIndex + (rIndex - lIndex) / 2;

            // return index if exact match
            if (l.get(mIndex) == num) {
                return mIndex;
            }

            // look at 2 indices around middle index
            int mBig = mIndex + 1;
            int mSmall = mIndex - 1;

            // check index bounds
            if (mBig >= len) {
                if (num < l.get(mIndex)) {
                    return mIndex;
                }
                return len;
            } else if (mSmall < 0) {
                if (num < l.get(mBig)) {
                    return num < l.get(mIndex) ? mIndex : mBig;
                }
                return Math.min(mBig + 1, len);
            }

            // case: num is smaller than value at index
            if (num < l.get(mIndex)) {
                // check 2 numbers around mIndex to determine if number is between mSmall and mBig
                if (l.get(mSmall) < num && l.get(mBig) > num) {
                    return mIndex;
                }
                // go left
                rIndex = mIndex - 1;
            } else {
                // case: num is greater than value at index
                // check 2 numbers around mIndex to determine if number is between mSmall and mBig
                if (l.get(mSmall) < num && l.get(mBig) > num) {
                    return mBig;
                }
                // go right
                lIndex = mIndex + 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Long> al = new ArrayList<>();

        while (scan.hasNextLong()) {
            long curNum = scan.nextLong();
            al.add(findInsertIndex(al, curNum), curNum);

            int len = al.size();
            if (len % 2 == 0) {
                // even length, divide
                System.out.println((al.get(len / 2) + al.get((len / 2) - 1)) / 2);
            } else {
                // odd length, just get
                System.out.println(al.get(len / 2));
            }
        }
    }
}
