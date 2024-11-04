package week6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P15686 {

    static int N, M, result;
    static LinkedList<int[]> cPos, hPos;
    static int[][] distance;
    static int[] chicken;
    public static void main(String[] args) throws Exception {
        //0 빈 칸, 1 집, 2 치킨 집
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //도시 NxN
        M = Integer.parseInt(st.nextToken()); //치킨집 수
        cPos = new LinkedList<>();//치킨집 위치
        hPos = new LinkedList<>();//집 위치
        chicken = new int[M];//선택한 치킨집
        result = Integer.MAX_VALUE;//결과값

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                int value = Integer.parseInt(st.nextToken());
                if(value==1)
                    hPos.add(new int[] {i, j});
                else if(value==2)
                    cPos.add(new int[] {i, j});
            }
        }
        //집 - 치킨집 거리 모두 계산하여 저장
        distance = new int[hPos.size()][cPos.size()];
        for(int i=0;i<hPos.size();i++) {
            int hx = hPos.get(i)[0];
            int hy = hPos.get(i)[1];
            for(int j=0;j<cPos.size();j++) {
                distance[i][j] = Math.abs(hx-cPos.get(j)[0]) + Math.abs(hy-cPos.get(j)[1]);
            }
        }
        //치킨집 M개 선택하는 조합
        combination(0, 0);
        System.out.println(result);
    }

    //치킨집 고르기
    public static void combination(int start, int cnt) {
        if(cnt==M) {
            int sum = 0;
            for(int i=0;i<hPos.size();i++) {
                int min = Integer.MAX_VALUE;
                //선택된 치킨집 중 가장 가까운 치킨집과의 거리
                for(int j=0;j<M;j++) {
                    min = Math.min(min, distance[i][chicken[j]]);
                }
                sum += min;
            }
            //전체 결과와 비교해 더 작은 값을 택
            result = Math.min(result, sum);
            return;
        }
        for(int i = start; i<cPos.size(); i++) {
            chicken[cnt] = i;
            combination(i+1, cnt+1);
        }
    }
}