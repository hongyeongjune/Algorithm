package 리트코드.LeetCode_209_MinimumSizeSubarraySum;

public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int answer = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        int sum = 0;

        while (j < nums.length) {
            sum += nums[j++];
            while (sum >= target) {
                answer = Math.min(answer, j - i);
                sum -= nums[i--];
            }
        }

        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
}
