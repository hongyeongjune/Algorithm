package 프로그래머스.Programmers_디스크컨트롤러;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Retry {
    public static int solution(int[][] jobs) {

        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        int time = 0;
        int index = 0;
        int answer = 0;

        while (true) {
            while (index < jobs.length && jobs[index][0] <= time) {
                queue.offer(jobs[index++]);
            }

            if (queue.isEmpty()) {
                time = jobs[index][0];
                continue;
            }

            int[] job = queue.poll();
            time += job[1];
            answer += (time - job[0]);
            if (index == jobs.length && queue.isEmpty())
                break;
        }

        return (int) (answer /= jobs.length);
    }
}
