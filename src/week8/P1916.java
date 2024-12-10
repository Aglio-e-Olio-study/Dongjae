package week8;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1916 {
    static int V; // 정점의 개수
    static int M; // 버스의 개수 == 간선의 개수
    static int[] D; // 최솟값을 저장할 배열
    static boolean[] visited; // 방문 배열

    static class Node {
        int myV;		// 내 정점 번호
        int cost;

        public Node(int v, int cost) {
            this.myV = v;
            this.cost = cost;
        }
    }
    static List<Node>[] nodeList;

    static int start, end;

    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        V = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        nodeList = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            nodeList[i] = new ArrayList<>();
        }

        StringTokenizer st;

        // 인접리스트 연결
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            nodeList[from].add(new Node(to, cost));
        }

        // 구하고자 하는 출발점과 도착점
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        // D배열, 방문 배열 초기화
        D = new int[V + 1];
        Arrays.fill(D, Integer.MAX_VALUE);

        visited = new boolean[V + 1];

        minCostDij();

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }

    // 다익스트라 함수
    private static void minCostDij() {
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.cost - o2.cost;
            }
        });

        // 시작 노드 넣기
        pq.add(new Node(start, 0));
        visited[start] = true;

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            // 꺼낸 노드가 도착지점이면 갱신, while 종료
            if (node.myV == end) {
                result = Integer.min(result, node.cost);
                break;
            }

            // 항상 다익스트라는 방문처리를 꺼냈을 때
            if (!visited[node.myV]) {
                visited[node.myV] = true;
            }

            // 내 인접 노드를 확인
            for (int i = 0; i < nodeList[node.myV].size(); i++) {
                Node next = nodeList[node.myV].get(i);
                if (next != null && !visited[next.myV]) {
                    if (D[next.myV] > node.cost + next.cost) {
                        D[next.myV] = node.cost + next.cost;
                        pq.add(new Node(next.myV, D[next.myV]));
                    }
                }
            }
        }
    }
}
