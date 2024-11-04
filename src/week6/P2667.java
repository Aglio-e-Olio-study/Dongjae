package week6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class P2667 {
    static int N;
    static int[][] area;
    static boolean[][] visited;
    static int[] moveX = {-1, 0, 1, 0};
    static int[] moveY = {0, 1, 0, -1};
    static ArrayList<Integer> result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        area = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String input = sc.next();
            for (int j = 0; j < N; j++) {
                area[i][j] = Integer.parseInt(input.charAt(j) + "");
            }
        }

        result = new ArrayList<Integer>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && area[i][j] == 1) {
                    int count = bfs(i, j);
                    result.add(count);
                }
            }
        }
        Collections.sort(result);
        System.out.println(result.size());
        for (int i : result) System.out.println(i);
        sc.close();
    }

    public static int bfs(int i, int j) {
        visited[i][j] = true;
        int count = 1;

        for (int k = 0; k < 4; k++) {
            int nx = i + moveX[k];
            int ny = j + moveY[k];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if (area[nx][ny] == 1 && !visited[nx][ny]) {
                    count += bfs(nx, ny);
                }
            }
        }
        return count;
    }
}
