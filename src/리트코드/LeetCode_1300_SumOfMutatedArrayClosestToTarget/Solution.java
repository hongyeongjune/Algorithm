package 리트코드.LeetCode_1300_SumOfMutatedArrayClosestToTarget;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public int findBestValue(int[] arr, int target) {
        int min = Integer.MAX_VALUE;
        int answer = 0;

        List<Integer> list = new ArrayList<>();
        for (int a : arr) list.add(a);

        Collections.sort(list);

        for (int i = 0; i <= target; i++) {
            int sum = 0;

            int index = lowerBound(list, i);

            for (int j = 0; j < index; j++) {
                sum += list.get(j);
            }
            sum += (i * (arr.length - index));

            if (min > Math.abs(target - sum)) {
                answer = i;
                min = Math.abs(target - sum);
            }
        }

        return answer;
    }

    private static int lowerBound(List<Integer> list, int target) {
        int left = 0;
        int right = list.size();

        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) >= target)
                right = mid;
            else left = mid + 1;
        }

        return right;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.findBestValue(new int[]{15, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 50);
    }
}
