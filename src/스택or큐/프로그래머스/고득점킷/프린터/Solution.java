package 스택or큐.프로그래머스.고득점킷.프린터;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public class Printer {
        int priorities;
        int location;

        public Printer(int priorities, int location) {
            this.priorities = priorities;
            this.location = location;
        }
    }

    public int solution(int[] priorities, int location) {
        int answer = 0;
        Integer[] p = new Integer[priorities.length];
        Queue<Printer> queue = new LinkedList<>();
        for(int i=0; i<priorities.length; i++) {
            p[i] = priorities[i];
        }
        Arrays.sort(p, Collections.reverseOrder());
        int index = 0;
        int i = 0;
        while(queue.size() < priorities.length) {
            if(priorities[i] == p[index]) {
                queue.offer(new Printer(priorities[i], i));
                index++;
            }
            i++;
            if(i == priorities.length) i = 0;
        }
        while(!queue.isEmpty()) {
            Printer printer = queue.poll();
            answer++;
            if(printer.location == location)
                return answer;
        }
        return answer;
    }
}
