package greedy.프로그래머스.구명보트;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public static int solution(int[] people, int limit) {
        int answer = 0;

        Queue<Integer> desc = new PriorityQueue<>();
        Queue<Integer> asc = new PriorityQueue<>(Collections.reverseOrder());

        for(int person : people) {
            desc.offer(person);
            asc.offer(person);
        }

        while(!desc.isEmpty() && !asc.isEmpty()) {

            if(desc.peek() + asc.peek() <= limit) {
                asc.remove(desc.poll());
                desc.remove(asc.poll());
                answer++;
            }

            else if(desc.peek() + asc.peek() > limit) {
                desc.remove(asc.poll());
                answer++;
            }

        }

        return answer;
    }
}
