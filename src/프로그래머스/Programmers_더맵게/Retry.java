package 프로그래머스.Programmers_더맵게;

import java.util.PriorityQueue;

public class Retry {
    public static int solution(int[] scoville, int K) {

        int answer = 0;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int s : scoville) {
            priorityQueue.offer(s);
        }

        while (priorityQueue.size() > 1 && priorityQueue.peek() < K) {
            int first = priorityQueue.poll();
            int second = priorityQueue.poll() * 2;
            priorityQueue.offer(first + second);
            answer++;
        }

        if (priorityQueue.size() == 1 && priorityQueue.peek() < K)
            return answer = -1;

        return answer;
    }

}
