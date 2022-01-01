package 프로그래머스.Programmers_더맵게;

import java.util.PriorityQueue;

public class Solution_다시시도2 {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int s : scoville) priorityQueue.offer(s);

        int answer = 0;

        while(priorityQueue.size() >= 2) {
            int first = priorityQueue.poll();
            int second = priorityQueue.poll();

            priorityQueue.offer(first + (second * 2));
            answer++;
            if(priorityQueue.peek() >= K) {
                return answer;
            }
        }

        return answer = -1;
    }
}
