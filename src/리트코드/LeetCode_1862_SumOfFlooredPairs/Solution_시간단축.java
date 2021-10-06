package 리트코드.LeetCode_1862_SumOfFlooredPairs;

import java.util.Arrays;
import java.util.HashMap;

public class Solution_시간단축 {
    public static int MOD = (int) Math.pow(10, 9) + 7;

    public int sumOfFlooredPairs(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        int[] counts = new int[2 * max + 1];

        for (int num : nums) {
            counts[num]++;
        }

        for (int i = 1; i <= (2 * max); i++)
            counts[i] += counts[i - 1];

        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                answer += map.get(num);
            } else {
                int sum = 0;
                int left = num;
                int right = 2 * num - 1;
                long quotient = 1;

                while (left <= max) {
                    sum += (quotient * (counts[right] - counts[left - 1])) % MOD;
                    sum %= MOD;
                    left += num;
                    right += num;
                    quotient++;
                }
                map.put(num, sum);
                answer += sum;
            }
            answer %= MOD;
        }

        return answer;
    }
}
