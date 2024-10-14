package week3;

import java.io.*;

public class P2529{
    static int k;
    static String[] sign;
    static boolean[] visited;
    static String max = "";
    static String min = "";
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        k = Integer.parseInt(br.readLine());
        sign = br.readLine().split(" ");
        visited = new boolean[10];

        // max,min값 초기화(k+1개의 0 또는 9로)
        for(int i=0; i <= k; i++){
            max += 0;
            min += 9;
        }

        solve(0, "");

        bw.write(max + "\n" + min);
        bw.flush();
        br.close();
    }

    private static void solve(int idx, String str){
        // k+1개의 숫자를 모두 선택했다면 비교 후 최대 & 최솟값 업데이트
        if(idx == k+1) {
            compare(str);
            return;
        }
        // direction은 부등호에 따라 < 면 이전 수보다 높은 수만, > 면 낮은 수만 비교하도록
        // 방향성을 결정하는 부분. 그러나 idx 값이 0이면 제일 처음 수행되는 것이므로 무조건 1로 지정
        // sign은 k개가 있는데 최초 idx값이 0이 전달되고 1부터 시작되니 idx-1로 지정
        int direction = idx == 0 || sign[idx-1].equals("<") ? 1 : -1;

        // start는 현재까지 결정된 숫자 중 가장 마지막 값을 찾아 direction을 더하는 변수
        // 만약 아무 결정된 숫자가 없다면 0으로 초기화
        int start = idx == 0 ? 0 : str.charAt(idx-1) - '0' + direction;

        // i값은 start 부터 시작하여 숫자를 결정 짓고 재귀를 수행
        for(int i=start; i >= 0 && i <= 9; i += direction){
            if(!visited[i]){
                visited[i] = true;
                solve(idx+1, str+i);
                visited[i] = false;
            }
        }
    }

    // 최대 / 최소값 비교
    private static void compare(String str){
        int i=0;
        int j=0;
        while(str.charAt(i) == max.charAt(i)) i++;
        if(i <= k && str.charAt(i) > max.charAt(i)) max = str;

        while(str.charAt(j) == min.charAt(j)) j++;
        if(j <= k && str.charAt(j) < min.charAt(j)) min = str;
    }
}
