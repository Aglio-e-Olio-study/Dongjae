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