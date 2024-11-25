package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1260 {

    static int N;
    static int M;
    static int V;
    static int[][] graph;
    static boolean[] visited;

    static Queue<Integer> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new int[N+1][N+1];
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        visited = new boolean[N+1];
        dfs(V);
        System.out.println();

        visited = new boolean[N+1];
        bfs(V);
    }

    public static void dfs(int start) {
        visited[start] = true;
        System.out.print(start + " ");
        for(int i=1; i<N+1; i++) {
            if(graph[start][i] == 1 && !visited[i]) dfs(i);
        }
    }

    public static void bfs(int start) {
        q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while(!q.isEmpty()) {
            int vertex = q.poll();
            System.out.print(vertex + " ");
            for(int i=1; i<N+1; i++) {
                if(graph[vertex][i] == 1 && !visited[i]) {
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
