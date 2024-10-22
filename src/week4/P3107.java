package week4;

import java.util.Scanner;

public class P3107 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        String[] ip = input.split(":");
        String[] ans = new String[8];

        int index = 0;
        boolean flag = false;

        for (int i = 0; i < 8; i++) {
            ans[i] = "0000";
        }

        for (int i = 0; i < ip.length; i++) {
            if (ip[i].length() == 4) {
                ans[index] = ip[i];
                index++;
            } else if (ip[i].length() > 0) {
                ans[index] = "0000".substring(ip[i].length()) + ip[i];
                index++;
            } else {
                if (!flag) {
                    index += (8 - ip.length + 1);
                    flag = true;
                } else {
                    ans[index] = "0000";
                    index++;
                }
            }
        }

        for (int i = 0; i < 7; i++) {
            System.out.print(ans[i] + ":");
        }
        System.out.println(ans[7]);

        sc.close();
    }
}

