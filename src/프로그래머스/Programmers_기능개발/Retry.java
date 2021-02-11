package 프로그래머스.Programmers_기능개발;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Retry {
    public int[] solution(int[] progresses, int[] speeds) {

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            int date = (int) Math.ceil(((double) 100 - progresses[i]) / speeds[i]);

            while (!queue.isEmpty() && queue.peek() < date) {
                result.add(queue.size());
                queue.clear();
            }

            queue.offer(date);
        }
        result.add(queue.size());

        int[] answer = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}
