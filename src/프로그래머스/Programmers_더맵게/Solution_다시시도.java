package 프로그래머스.Programmers_더맵게;

import java.util.PriorityQueue;

public class Solution_다시시도 {
    public static int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s : scoville) pq.offer(s);

        int answer = 0;
        while (pq.size() >= 2 && pq.peek() < K) {
            int first = pq.poll();
            int second = pq.poll();
            pq.offer(first + (second * 2));
            answer++;
        }

        return pq.peek() < K ? -1 : answer;
    }
}
