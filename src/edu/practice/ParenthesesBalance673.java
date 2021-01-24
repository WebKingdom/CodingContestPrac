package edu.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class ParenthesesBalance673 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int testCases = Integer.parseInt(st.nextToken());

        for (int i = 0; i < testCases; i++) {
            String str = br.readLine();
            Stack<Character> stack = new Stack<>();
            boolean valid = true;

            for (int j = 0; j < str.length(); j++) {
                char curChar = str.charAt(j);

                if (curChar == '(' || curChar == '[') {
                    stack.push(curChar);
                } else if (curChar != ' ') {
                    if (stack.isEmpty()) {
                        System.out.println("No");
                        valid = false;
                        break;
                    }
                    char popped = stack.pop();

                    // If popped matches curChar logic
                    if (curChar == ']' && popped != '[') {
                        valid = false;
                        System.out.println("No");
                        break;
                    } else if (curChar == ')' && popped != '(') {
                        valid = false;
                        System.out.println("No");
                        break;
                    }
                }
            }

            if (valid && stack.isEmpty()) {
                System.out.println("Yes");
            } else if (valid) {
                System.out.println("No");
            }
        }
    }
}
