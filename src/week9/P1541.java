package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");
        int size = st.countTokens();
        String[] strArray = new String[size];

        for(int i=0; i<size; i++) {
            strArray[i] = st.nextToken();
            if(strArray[i].indexOf("+") != -1) {
                int ele = 0;
                for(String num : strArray[i].split("\\+")) {
                    ele += Integer.parseInt(num);
                }
                strArray[i] = Integer.toString(ele);
            }
        }

        int sum = Integer.parseInt(strArray[0]);
        for(int i=1; i<size; i++) {
            sum -= Integer.parseInt(strArray[i]);
        }
        System.out.println(sum);
    }
}
