package edu.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class AgeSort11462 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        while (n != 0) {
            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                int age = Integer.parseInt(st.nextToken());
                arr[i] = age;
            }

            Arrays.sort(arr);
            // print in correct format
            for (int i = 0; i < n; i++) {
                if (i == (n - 1)) {
                    System.out.println(arr[i]);
                } else {
                    System.out.print(arr[i] + " ");
                }
            }

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
        }
    }
}
