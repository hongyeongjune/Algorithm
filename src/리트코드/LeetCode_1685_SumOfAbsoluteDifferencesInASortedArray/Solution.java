package 리트코드.LeetCode_1685_SumOfAbsoluteDifferencesInASortedArray;

public class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int[] answer = new int[nums.length];
        int[] sum = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            answer[i] = (nums[i] * i - sum[i]) +
                    (sum[nums.length] - sum[i] - (nums.length - i) * nums[i]);
        }

        return answer;
    }
}
