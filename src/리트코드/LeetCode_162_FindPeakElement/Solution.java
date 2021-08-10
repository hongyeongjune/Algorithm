package 리트코드.LeetCode_162_FindPeakElement;

public class Solution {
    public int findPeakElement(int[] nums) {
        int answer = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                answer = i;
                max = nums[i];
            }
        }

        return answer;
    }
}
