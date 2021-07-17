package 프로그래머스.Programmers_이중우선순위큐;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_다시시도 {
    public static int[] solution(String[] operations) {
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minQ = new PriorityQueue<>();

        for (String operation : operations) {
            String[] split = operation.split(" ");
            switch (split[0]) {
                case "I":
                    maxQ.offer(Integer.parseInt(split[1]));
                    minQ.offer(Integer.parseInt(split[1]));
                    break;
                case "D":
                    if (split[1].equals("-1")) {
                        maxQ.remove(minQ.poll());
                    } else if (split[1].equals("1")) {
                        minQ.remove(maxQ.poll());
                    }
            }
        }

        int[] answer = {0, 0};

        if (minQ.size() >= 2) {
            answer[0] = maxQ.peek();
            answer[1] = minQ.peek();
        }

        return answer;
    }
}
