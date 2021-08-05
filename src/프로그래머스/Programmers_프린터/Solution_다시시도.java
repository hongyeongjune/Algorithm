package 프로그래머스.Programmers_프린터;

import java.util.*;

public class Solution_다시시도 {
    public int solution(int[] priorities, int location) {
        List<Integer> priorityList = new ArrayList<>();
        for (int priority : priorities) priorityList.add(priority);
        Collections.sort(priorityList, Collections.reverseOrder());

        Queue<Printer> queue = new LinkedList<>();

        int i = 0, j = 0;
        while (queue.size() < priorities.length) {
            if (priorityList.get(i) == priorities[j]) {
                queue.offer(new Printer(priorities[j], j));
                i++;
            }
            j++;
            if (priorities.length == j) j = 0;
        }

        int answer = 0;
        while (!queue.isEmpty()) {
            Printer printer = queue.poll();
            answer++;
            if (printer.location == location)
                return answer;
        }

        return answer;
    }

    public class Printer {
        private int importance;
        private int location;

        public Printer(int importance, int location) {
            this.importance = importance;
            this.location = location;
        }
    }
}
