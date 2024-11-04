package week5;

import java.io.*;
import java.util.*;

public class P1450 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int maxWeight = Integer.parseInt(st.nextToken());

        int[] weights = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
        }

        // 배열을 2분할, 각 부분합
        List<Integer> leftSums = calcSubsetSums(Arrays.copyOfRange(weights, 0, n / 2));
        List<Integer> rightSums = calcSubsetSums(Arrays.copyOfRange(weights, n / 2, n));
        // 오른쪽 부분합 정렬
        Collections.sort(rightSums);
        int count = 0;
        for (int leftSum : leftSums) {
            if (leftSum <= maxWeight) {
                count += countValidSums(rightSums, maxWeight - leftSum);
            }
        }
        System.out.println(count);
    }

    // 모든 부분합
    private static List<Integer> calcSubsetSums(int[] array) {
        List<Integer> subsetSums = new ArrayList<>();
        findSums(array, 0, 0, subsetSums);
        return subsetSums;
    }

    // 재귀 호출로 부분합
    private static void findSums(int[] array, int idx, int currentSum, List<Integer> subsetSums) {
        if (idx == array.length) {
            subsetSums.add(currentSum);
            return;
        }
        findSums(array, idx + 1, currentSum, subsetSums);
        findSums(array, idx + 1, currentSum + array[idx], subsetSums);
    }

    // 정렬 리스트에서 타겟이하의 값 개수
    private static int countValidSums(List<Integer> sortedList, int target) {
        int left = 0;
        int right = sortedList.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (sortedList.get(mid) <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
