import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Randompair {
    public static void main(String[] args) {
        List<String> member = Arrays.asList("동재", "우진", "민선", "지언", "주훈", "민지", "하늘");
        Collections.shuffle(member);

        for (int i = 0; i < member.size(); i += 2) {
            System.out.println(member.get(i) + " & " + member.get(i + 1));
        }
    }
}

import java.io.*;
        import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 초기 입력값 받기
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        // 격자판의 초기 상태 및 현재 상태를 저장할 배열 선언
        char[][] graph = new char[r][c];
        char[][] original = new char[r][c];

        // 초기 상태 입력
        for (int x = 0; x < r; x++) {
            String row = br.readLine();
            for (int y = 0; y < c; y++) {
                graph[x][y] = row.charAt(y);
                original[x][y] = row.charAt(y);
            }
        }

        // 초 단위로 반복
        for (int i = 2; i <= n; i++) {
            // 폭탄 설치 및 폭탄이 터지는 시점에 대한 조건문
            int[][] direction = {{0, 0}, {1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            if (i % 4 == 2 || i % 4 == 0) {
                // 2초 또는 4초일 때, 모든 칸에 폭탄 설치
                for (int x = 0; x < r; x++) {
                    for (int y = 0; y < c; y++) {
                        graph[x][y] = 'O';
                    }
                }
            } else {
                // 폭탄 터지는 시점일 때, 폭탄 터지는 로직 수행
                for (int x = 0; x < r; x++) {
                    for (int y = 0; y < c; y++) {
                        if (original[x][y] == 'O') {
                            for (int d = 0; d < 5; d++) {
                                int newX = x + direction[d][0];
                                int newY = y + direction[d][1];
                                // 주변 5방향으로 폭탄이 터지도록 설정
                                if (0 <= newX && newX < r && 0 <= newY && newY < c) {
                                    graph[newX][newY] = '.';
                                }
                            }
                        }
                    }
                }
                // 현재 상태 갱신
                for (int x = 0; x < r; x++) {
                    for (int y = 0; y < c; y++) {
                        original[x][y] = graph[x][y];
                    }
                }
            }
        }

        // 최종 결과 출력
        for (int x = 0; x < r; x++) {
            for (int y = 0; y < c; y++) {
                sb.append(graph[x][y]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}