import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Randompair {
    public static void main(String[] args) {
        List<String> member = Arrays.asList("동재", "우진", "민선", "지언", "주훈", "민지");
        Collections.shuffle(member);

        for (int i = 0; i < member.size(); i += 2) {
            System.out.println(member.get(i) + " & " + member.get(i + 1));
        }
    }
}