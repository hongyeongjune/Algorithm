package 리트코드.LeetCode_300_LongestIncreasingSubsequence;

public class Solution {
    public int lengthOfLIS(int[] nums) {

        int[] memo = new int[nums.length];
        memo[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            memo[i] = 1;
        }

        return 0;
    }
}
