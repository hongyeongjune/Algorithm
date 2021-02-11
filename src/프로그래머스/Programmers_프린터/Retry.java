package 프로그래머스.Programmers_프린터;

import java.util.*;

public class Retry {
    public static class Printer {
        int printer;
        int location;

        public Printer(int printer, int location) {
            this.printer = printer;
            this.location = location;
        }

    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Printer> queue = new LinkedList<>();
        Integer[] p = new Integer[priorities.length];

        for (int i = 0; i < priorities.length; i++) {
            p[i] = priorities[i];
        }

        Arrays.sort(p, Collections.reverseOrder());
        int index = 0;
        int i = 0;

        while (queue.size() < priorities.length) {

            if (p[index] == priorities[i]) {
                queue.offer(new Printer(priorities[i], i));
                index++;
            }

            i++;

            if (i == priorities.length) i = 0;
        }

        while (!queue.isEmpty()) {
            Printer printer = queue.poll();
            answer++;
            if (printer.location == location) return answer;
        }

        return answer;
    }

}
