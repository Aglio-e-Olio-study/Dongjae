package week5;

import java.io.*;
import java.util.*;

public class P1535 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] l = new int[n]; // 잃는체력  list
        int[] g = new int[n]; // 얻는행복 list

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            l[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            g[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[100];
        for (int i = 0; i < n; i++) {
            for (int j = 99; j >= l[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - l[i]] + g[i]);
            }
        }
        System.out.println(dp[99]);
    }
}

