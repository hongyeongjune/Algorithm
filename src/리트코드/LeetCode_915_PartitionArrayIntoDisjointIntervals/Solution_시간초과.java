package 리트코드.LeetCode_915_PartitionArrayIntoDisjointIntervals;

import java.util.PriorityQueue;

public class Solution_시간초과 {
    public int partitionDisjoint(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                pq.offer(nums[j]);
            }
            max = Math.max(max, nums[i]);
            if (max <= pq.peek())
                return i + 1;
            pq.clear();
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution_시간초과 solution시간단축 = new Solution_시간초과();
        solution시간단축.partitionDisjoint(new int[]{5, 0, 3, 8, 6});
        solution시간단축.partitionDisjoint(new int[]{1, 1, 1, 0, 6, 12});
    }
}
