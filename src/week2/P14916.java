package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P14916 {
    public static void main(String[] args) throws IOException {
        proc();
    }

    public static void proc() throws IOException {
        int result = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        while (N > 0) {
            if (N % 5 == 0) {
                result += (N / 5);
                N = 0;
            } else {
                N -= 2;
                result++;
            }
        }

        if (N == 0) {
            System.out.println(result);
        } else {
            System.out.println(-1);
        }
    }
}
