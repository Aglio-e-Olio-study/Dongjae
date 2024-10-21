package week4;

import java.util.Scanner;

public class P15927 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        int len = str.length();

        // 회문인지 확인
        if (!isPalindrome(str)) {
            System.out.println(len);
        } else if (allSameCharacters(str)) {
            System.out.println(-1);
        } else {
            System.out.println(len - 1);
        }

        sc.close();
    }

    // 문자열이 회문인지 확인
    private static boolean isPalindrome(String str) {
        int len = str.length();
        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    private static boolean allSameCharacters(String str) {
        char firstChar = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != firstChar) {
                return false;
            }
        }
        return true;
    }
}

