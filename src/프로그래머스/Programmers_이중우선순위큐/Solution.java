package 프로그래머스.Programmers_이중우선순위큐;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public static int[] solution(String[] operations) {
        int[] answer = new int[2];
        Queue<Integer> minQ = new PriorityQueue<>();

        int index = 0;

        while(index < operations.length) {

            if(operations[index].charAt(0) == 'I') {
                minQ.offer(Integer.parseInt(operations[index].substring(2)));
                index++;
            }

            else if(operations[index].charAt(0) == 'D' && operations[index].substring(2).equals("1")) {
                index++;
                Queue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
                while(!minQ.isEmpty()) {
                    maxQ.offer(minQ.poll());
                }

                if(!maxQ.isEmpty()) {
                    if(maxQ.size() == 1)
                        minQ.poll();
                    maxQ.poll();
                }

                while(!maxQ.isEmpty()) {
                    minQ.offer(maxQ.poll());
                }


            }
            else if(operations[index].charAt(0) == 'D' && operations[index].substring(2).equals("-1")) {
                index++;
                if(!minQ.isEmpty()) {
                    minQ.poll();
                }
            }
        }

        if(minQ.isEmpty()) {
            answer[0] = 0;
            answer[1] = 0;
        }
        else {
            answer[1] = minQ.poll();
            Queue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
            while (!minQ.isEmpty()) {
                maxQ.offer(minQ.poll());
            }
            answer[0] = maxQ.poll();
        }



        return answer;
    }
}
