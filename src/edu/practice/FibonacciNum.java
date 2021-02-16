package edu.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FibonacciNum {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long tStart = System.nanoTime();
        int fibNum = calcFib(N);

        long runtime  = System.nanoTime() - tStart;
        System.out.println("Runtime: " + runtime + "ns = " + runtime / 1000.0 + "us");
        System.out.println("Fibonacci number " + N + " : " + fibNum);
    }

    private static int calcFib(int n) {
        if (n <= 1) {
            return n;
        }

        return calcFib(n - 1) + calcFib(n - 2);
    }
}
