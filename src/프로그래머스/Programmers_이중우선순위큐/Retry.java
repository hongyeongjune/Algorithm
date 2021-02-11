package 프로그래머스.Programmers_이중우선순위큐;

import java.util.Collections;
import java.util.PriorityQueue;

public class Retry {
    public static int[] solution(String[] operations) {
        int[] answer = new int[2];

        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < operations.length; i++) {
            String[] temp = operations[i].split(" ");
            switch (temp[0]) {
                case "I":
                    minQ.offer(Integer.parseInt(temp[1]));
                    maxQ.offer(Integer.parseInt(temp[1]));
                    break;
                case "D":
                    if (temp[1].equals("-1")) {
                        maxQ.remove(minQ.poll());
                    } else if (temp[1].equals("1")) {
                        minQ.remove(maxQ.poll());
                    }
                    break;
            }
        }

        if (minQ.size() >= 2) {
            answer[0] = maxQ.poll();
            answer[1] = minQ.poll();
        }

        return answer;
    }
}
