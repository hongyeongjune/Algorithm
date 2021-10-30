package 프로그래머스.Programmers_기능개발;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution_다시풀기 {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<progresses.length; i++) {
            int day = (int) Math.ceil((100 - progresses[i]) / speeds[i]);

            if(!queue.isEmpty() && queue.peek() < day) {
                list.add(queue.size());
                queue.clear();;
            }
            queue.offer(day);
        }
        if(!queue.isEmpty()) list.add(queue.size());

        int[] answer = new int[list.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution_다시풀기 solution = new Solution_다시풀기();
        solution.solution(new int[]{96, 94}, new int[]{3, 3});
    }
}
