package edu.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class InputReaderTest {

    /**
     * Input reader class using BufferReader, InputStreamReader, and StringTokenizer to get input for
     * large test cases quickly
     */
    private static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String arg) {
            br = new BufferedReader(new StringReader(arg));
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double parseDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args) throws IOException {
        final int NUM_TESTS = 10;
        final String STR_ARG = "7 3\n" +
                "1\n" +
                "51\n" +
                "966369\n" +
                "7\n" +
                "9\n" +
                "999996\n" +
                "11\n" +
                "16234\n" +
                "32\n" +
                "237986976\n" +
                "22\n" +
                "7765\n" +
                "978978996\n" +
                "21";

        double avgTime = 0.0;

        // Test 1
        for (int i = 0; i < NUM_TESTS; i++) {
            long tStart = System.nanoTime();
            FastReader fr = new FastReader(STR_ARG);

            int n = fr.nextInt();
            int k = fr.nextInt();
            int count = 0;

            while (n-- > 0) {
                int x = fr.nextInt();
                if (x % k == 0) {
                    count++;
                }
            }
//            System.out.println(count);
            long tEnd = System.nanoTime();
            avgTime += tEnd - tStart;
        }
        System.out.println("Avg Runtime 1: " + (avgTime / NUM_TESTS));
        avgTime = 0;

        // Test 2
        for (int i = 0; i < NUM_TESTS; i++) {
            long tStart = System.nanoTime();

            BufferedReader br = new BufferedReader(new StringReader(STR_ARG));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int count = 0;
            while (n-- > 0) {
                int x = Integer.parseInt(br.readLine());
                if (x%k == 0) {
                    count++;
                }
            }
//            System.out.println(count);
            long tEnd = System.nanoTime();
            avgTime += tEnd - tStart;
        }
        System.out.println("Avg Runtime 2: " + (avgTime / NUM_TESTS));
    }
}
