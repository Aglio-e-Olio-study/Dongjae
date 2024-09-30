package week1;

import java.io.*;
import java.util.StringTokenizer;

public class P16918 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        // 격자판 초기 상태, 현재 상태를 저장하는 배열
        char[][] graph = new char[r][c];
        char[][] original = new char[r][c];

        // 격자판 초기 상태 입력
        for (int x = 0; x < r; x++) {
            String row = br.readLine();
            for (int y = 0; y < c; y++) {
                graph[x][y] = row.charAt(y);
                original[x][y] = row.charAt(y);
            }
        }

        // 초단위로 반복
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                // 짝수 시간일 때 모든 칸에 폭탄 설치
                for (int x = 0; x < r; x++) {
                    for (int y = 0; y < c; y++) {
                        graph[x][y] = 'O';
                    }
                }
            } else if (i > 1 && i % 2 != 0) {
                // 홀수 시간이고 1초가 아닐 때 폭발 처리
                for (int x = 0; x < r; x++) {
                    for (int y = 0; y < c; y++) {
                        if (original[x][y] == 'O') {
                            graph[x][y] = '.';
                            if (x > 0) graph[x-1][y] = '.';
                            if (x < r-1) graph[x+1][y] = '.';
                            if (y > 0) graph[x][y-1] = '.';
                            if (y < c-1) graph[x][y+1] = '.';
                        }
                    }
                }
                // 원본 격자 업데이트
                for (int x = 0; x < r; x++) {
                    for (int y = 0; y < c; y++) {
                        original[x][y] = graph[x][y];
                    }
                }
            }
        }

        for (int x = 0; x < r; x++) {
            for (int y = 0; y < c; y++) {
                sb.append(graph[x][y]);
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}

