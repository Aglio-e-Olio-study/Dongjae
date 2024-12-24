package week10;

import java.util.Scanner;

public class P11055 {
    public static int n, arr[], d[];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        arr = new int[n];
        d = new int[n];
        int max = d[0];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            d[i] = arr[i];
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && d[i] < d[j] +arr[i]) {
                    d[i] = d[j] + arr[i];
                }
            }
        }
        for(int i = 0; i < n; i++) {
            if(max < d[i]) {
                max = d[i];
            }
        }
        System.out.println(max);
    }
}
