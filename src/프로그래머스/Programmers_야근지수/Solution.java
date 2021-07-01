package 프로그래머스.Programmers_야근지수;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int work : works)
            pq.offer(work);

        while (n >= 1) {
            if (pq.peek() == 0) {
                return 0;
            }

            int work = pq.poll();
            work -= 1;
            pq.offer(work);
            n--;
        }

        while (!pq.isEmpty()) {
            answer += Math.pow(pq.poll(), 2);
        }

        return answer;
    }
}
