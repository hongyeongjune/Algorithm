package HeapSort.프로그래머스.더맵게;

import java.util.PriorityQueue;

public class Others {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int s : scoville)
            queue.add(s);

        int count = 0;

        while(queue.size() > 1 && queue.peek() < K){
            int weakHot = queue.poll();
            int secondWeakHot = queue.poll();

            int mixHot = weakHot + (secondWeakHot * 2);
            queue.add(mixHot);
            count++;
        }

        if(queue.size() <= 1 && queue.peek() < K)
            count = -1;

        return count;
    }
}
