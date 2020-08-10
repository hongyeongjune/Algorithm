package 스택or큐.프로그래머스.고득점킷.기능개발;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> answers = new ArrayList<>();

        for(int i=0; i<progresses.length; i++) {
            int date = (int) Math.ceil((100-progresses[i])/(double)speeds[i]);

            while(!queue.isEmpty() && queue.peek() < date) {
                answers.add(queue.size());
                queue.clear();
            }

            queue.offer(date);
        }

        answers.add(queue.size());

        int[] answer = new int[answers.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = answers.get(i);
        }


        return answer;
    }
}
