package 리트코드.LeetCode_1862_SumOfFlooredPairs;

import java.util.Arrays;

public class Solution {
    public static int MOD = (int) Math.pow(10, 9) + 7;

    public int sumOfFlooredPairs(int[] nums) {
        Arrays.sort(nums);

        int answer = 0;

        for (int i = 0; i < nums.length; i++) {
            int index = upperBound(nums, nums[i]);
            for (int j = 0; j < index; j++) {
                answer += (nums[i] / nums[j]);
                answer %= MOD;
            }
        }
        return answer;
    }

    public int upperBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = (left + right) / 2;

            if (nums[mid] <= target) {
                left = mid + 1;
            } else right = mid;
        }

        return right;
    }
}
