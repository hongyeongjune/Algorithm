package 프로그래머스.Programmers_프린터;

import java.util.*;

public class Solution_다시시도2 {
    public int solution(int[] priorities, int location) {

        Queue<Printer> queue = new LinkedList<>();
        for(int i=0; i<priorities.length; i++) {
            queue.offer(new Printer(priorities[i], i));
        }

        int index = 0;

        Integer[] arr = Arrays.stream(priorities).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, Collections.reverseOrder());

        while(index < priorities.length) {
            if(queue.peek().priority != arr[index]) {
                queue.offer(queue.poll());
                continue;
            }

            Printer printer = queue.poll();
            index++;
            if(printer.location == location) {
                return index;
            }
        }

        return index;
    }

    public class Printer {
        int priority;
        int location;

        public Printer(int priority, int location) {
            this.priority = priority;
            this.location = location;
        }
    }
}
