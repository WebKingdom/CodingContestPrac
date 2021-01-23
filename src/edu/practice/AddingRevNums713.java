package edu.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class AddingRevNums713 {

    private static BigInteger revNum(String toRev) {
        int len = toRev.length();
        boolean ignoreZero = toRev.charAt(len - 1) == '0';
        StringBuilder retNum = new StringBuilder(len);

        for (int i = len - 1; i >= 0; i--) {
            if ((!ignoreZero || toRev.charAt(i) != '0') && toRev.charAt(i) != '.') {
                retNum.append(toRev.charAt(i));
                ignoreZero = false;
            }
        }
        return new BigInteger(retNum.toString());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numCases = Integer.parseInt(st.nextToken());

        while (numCases-- > 0) {
            st = new StringTokenizer(br.readLine());
            System.out.println( revNum( revNum(st.nextToken()).add(revNum(st.nextToken())).toString() ) );
        }
    }
}
