package 리트코드.LeetCode_1855_MaximumDistanceBetweenAPairOfValues;

import java.util.Arrays;

public class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {

        int answer = 0;

        Arrays.sort(nums2);
        for (int i = 0; i < nums1.length; i++) {
            int index = lowerBound(nums2, nums1[i]);
            answer = Math.max(answer, nums2.length - 1 - index - i);
        }

        return answer;
    }

    private static int lowerBound(int[] data, int target) {
        int begin = 0;
        int end = data.length;

        while (begin < end) {
            int mid = (begin + end) / 2;

            if (data[mid] >= target) {
                end = mid;
            } else {
                begin = mid + 1;
            }
        }
        return end;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.maxDistance(new int[]{2, 2, 2}, new int[]{10, 10, 1});
    }
}
