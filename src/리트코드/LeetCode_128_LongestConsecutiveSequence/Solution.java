package 리트코드.LeetCode_128_LongestConsecutiveSequence;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution {
    public int longestConsecutive(int[] nums) {

        if (nums.length == 0) return 0;

        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        PriorityQueue<Integer> pq = new PriorityQueue<>(set);
        int answer = 0;
        int count = 0;

        while (!pq.isEmpty()) {
            int value = pq.poll();
            if (!pq.isEmpty() && value + 1 == pq.peek()) count++;
            else count = 0;
            answer = Math.max(answer, count);
        }

        return answer + 1;
    }
}


