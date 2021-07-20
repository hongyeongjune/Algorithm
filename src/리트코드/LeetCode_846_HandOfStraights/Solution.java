package 리트코드.LeetCode_846_HandOfStraights;

import java.util.PriorityQueue;

public class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int h : hand) pq.offer(h);

        while (!pq.isEmpty()) {
            int value = pq.poll();
            for (int i = 1; i < groupSize; i++) {
                if (pq.remove(value + i))
                    continue;
                else return false;
            }
        }

        return true;
    }
}
