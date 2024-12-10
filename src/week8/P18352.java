package week8;

import java.util.*;

public class P18352 {
    static int[] visited;//방문거리
    static ArrayList<Integer>[] list;
    static List<Integer> answer;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //노드 수
        int m = sc.nextInt(); //에지 수
        int k = sc.nextInt(); //목표거리
        int x = sc.nextInt(); //시작점
        list = new ArrayList[n+1]; //도시 번호 시작 1부터
        answer = new ArrayList<>();

        for(int i=1;i<=n;i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0;i<m;i++){
            int s = sc.nextInt();
            int e = sc.nextInt();
            list[s].add(e);
        }

        visited = new int[n+1];
        for(int i=1;i<=n;i++){
            visited[i] = -1;//방문하지 않은 노드를 -1로 초기화
        }
        BFS(x); //시작점부터 BFS

        //거리가 k인 도시 번호 추가
        for(int i=1;i<=n;i++){
            if(visited[i] == k){
                answer.add(i);
            }
        }

        //구한 결과가 비어있으면
        if(answer.isEmpty()){
            System.out.println("-1");
        } else {
            Collections.sort(answer);
            for(int i : answer){
                System.out.println(i);
            }
        }
    }
    static void BFS(int node){
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(node);//시작 노드를 큐에 추가
        visited[node]++;
        while(!q.isEmpty()){
            int now = q.poll();
            //현재 노드와 연결된 모든 노드에 대해
            for(int i : list[now]){
                if(visited[i]==-1){//방문 안한 노드면
                    visited[i] = visited[now]+1;//현재 노드의 거리 + 1을 저장
                    q.add(i);
                }
            }
        }
    }

}