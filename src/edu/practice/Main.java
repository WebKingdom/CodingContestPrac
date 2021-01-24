package edu.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    // 10523 Very Easy !!!
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            BigInteger N = new BigInteger(st.nextToken());
            BigInteger A;

            if (st.hasMoreTokens()) {
                A = new BigInteger(st.nextToken());
            } else {
                continue;
            }

            System.out.println(seriesSum(N, A));
            st = new StringTokenizer(br.readLine());
        }
    }

    private static BigInteger seriesSum(BigInteger i, BigInteger a) {
        if (i.intValue() == 1) {
            return a;
        }
        return i.multiply(a.pow(i.intValue())).add(seriesSum(i.subtract(new BigInteger("1")), a));
    }
}
