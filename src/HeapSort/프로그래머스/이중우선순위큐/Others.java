package HeapSort.프로그래머스.이중우선순위큐;

import java.util.Collections;
import java.util.PriorityQueue;

public class Others {
    public int[] solution(String[] arguments) {
        int[] answer = {0,0};

        PriorityQueue<Integer> minQ = new PriorityQueue<Integer>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<Integer>(Collections.reverseOrder());

        for(int i=0; i<arguments.length; i++) {
            String temp[] = arguments[i].split(" ");
            switch(temp[0]) {
                case "I" :
                    minQ.add(Integer.parseInt(temp[1]));
                    maxQ.add(Integer.parseInt(temp[1]));
                    break;
                case "D" :
                    if(minQ.size() > 0) {
                        if(Integer.parseInt(temp[1]) == 1) {
                            // 최댓값 삭제
                            int max = maxQ.poll();
                            minQ.remove(max);
                        } else {
                            // 최솟값 삭제
                            int min = minQ.poll();
                            maxQ.remove(min);
                        }
                    }
                    break;
            }
        }

        if(minQ.size() >= 2) {
            answer[0] = maxQ.poll();
            answer[1] = minQ.poll();
        }

        return answer;
    }
}
