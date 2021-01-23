package edu.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class GoodSequence264B {

    // Finds all non multiple divisors for number n.
    private static ArrayList<Integer> lowestDivs(int n) {
        ArrayList<Integer> listDivs = new ArrayList<>();

        if (n % 2 == 0) {
            listDivs.add(2);
        }

        for (int i = 3; i <= n; i += 2) {
            // i divides n
            if (n % i == 0) {

                if (listDivs.isEmpty()) {
                    listDivs.add(i);
                    continue;
                }

                // ensure not multiples
                boolean addVal = true;
                for (int num : listDivs) {

                    if (num >= i) {
                        addVal = false;
                        break;
                    }
                    if (i % num == 0) {
                        // not multiple
                        addVal = false;
                        break;
                    }
                }
                if (addVal) {
                    listDivs.add(i);
                }
            }
        }
        return listDivs;
    }

    private static int lowestDiv(int n) {
        if (n % 2 == 0) {
            return 2;
        }

        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return i;
            }
        }

        return n;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int seqLen = Integer.parseInt(st.nextToken());
        int[] arrNum = new int[seqLen];
        boolean firstPass = true;
        int longestSeq = 0;

        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < seqLen; i++) {
            int curNum;
            if (firstPass) {
                curNum = Integer.parseInt(st.nextToken());
                arrNum[i] = curNum;
            } else {
                curNum = arrNum[i];
            }
            ArrayList<Integer> divs = lowestDivs(curNum);

            for (int div : divs) {
                if (!hm.containsKey(div)) {
                    // Create list for number sequence for div
                    ArrayList<Integer> seqList = new ArrayList<>();
                    // Divisor is part of sequence list
                    seqList.add(div);

                    for (int j = i + 1; j < seqLen; j++) {
                        if (firstPass) {
                            arrNum[j] = Integer.parseInt(st.nextToken());
                        }
                        if (arrNum[j] % div == 0) {
                            // number is divisible by a unique divisor
                            seqList.add(arrNum[j]);
                        }
                    }
                    if (seqList.size() > longestSeq) {
                        longestSeq = seqList.size();
                    }
                    hm.put(div, seqList);
                    firstPass = false;
                }
            }
        }

        System.out.println(longestSeq);
    }

    // TODO old:
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int seqLen = Integer.parseInt(st.nextToken());
//        int[] arrNum = new int[seqLen];
//        boolean firstPass = true;
//
//        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
//        st = new StringTokenizer(br.readLine());
//
//        for (int i = 0; i < seqLen; i++) {
//            int curNum = firstPass ? Integer.parseInt(st.nextToken()) : arrNum[i];
//            int div = lowestDiv(curNum);
//            if (div == 1) {
//                arrNum[i] = curNum;
//                continue;
//            }
//
//            if (!hm.containsKey(div)) {
//                // Create list for number sequence for div
//                ArrayList<Integer> seqList = new ArrayList<>();
//                for (int j = i; j < seqLen; j++) {
//                    if (firstPass) {
//                        arrNum[j] = Integer.parseInt(st.nextToken());
//                    }
//                    if (arrNum[j] % div == 0) {
//                        // number is divisible by smallest divisor
//                        seqList.add(arrNum[j]);
//                    }
//                }
//                hm.put(arrNum[i], seqList);
//                firstPass = false;
//            }
//        }
//
//    }
}
