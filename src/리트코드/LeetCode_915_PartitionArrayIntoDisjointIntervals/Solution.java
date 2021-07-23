package 리트코드.LeetCode_915_PartitionArrayIntoDisjointIntervals;

public class Solution {
    public int partitionDisjoint(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            left[i] = max;
        }

        int min = Integer.MAX_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            min = Math.min(min, nums[i]);
            right[i] = min;
        }

        for (int i = 1; i < nums.length; i++) {
            if (left[i - 1] <= right[i]) return i;
        }

        return nums.length;
    }
}
