package week1;

import java.io.*;
import java.util.*;

public class P2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int size = s.length();
        int result = 0;
        int current = 1;

        try {
            for (int i = 0; i < size; i++) {
                char ch = s.charAt(i);
                if (ch == '(') {
                    current *= 2;
                    stack.push(ch);
                } else if (ch == '[') {
                    current *= 3;
                    stack.push(ch);
                } else if (ch == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        result = 0;
                        return;
                    }
                    if (s.charAt(i - 1) == '(') {
                        result += current;
                    }
                    stack.pop();
                    current /= 2;
                } else if (ch == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        result = 0;
                        return;
                    }
                    if (s.charAt(i - 1) == '[') {
                        result += current;
                    }
                    stack.pop();
                    current /= 3;
                }
            }
            if (!stack.isEmpty()) result = 0;
        } finally {
            sb.append(result);
            bw.write(sb.toString());
            bw.flush();
            bw.close();
        }
    }
}
