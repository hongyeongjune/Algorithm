package 프로그래머스.Programmers_디스크컨트롤러;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Others {
    public int solution(int[][] jobs) {

        // 요청 시간 기준 정렬
        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        // 소요 시간 기준 정렬
        Queue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int time = 0;
        int index = 0;
        int answer = 0;

        while(true) {

            // 하나의 작업이 완료되는 시점(time)까지 들어온 모든 요청을 큐에 넣음
            while(index < jobs.length && jobs[index][0] <= time) {
                queue.offer(jobs[index++]);
            }

            // 큐가 비어있다면 작업 완료 이후에 다시 요청이 들어온다
            if(queue.isEmpty()) {
                time = jobs[index][0];
                continue;
            }

            //작업이 끝나기 전 들어온 요청 중 가장 수행시간이 짧은 요청부터 수행
            int[] job = queue.poll();
            time += job[1];
            answer += time - job[0];
            if(index == jobs.length && queue.isEmpty()) {
                break;
            }
        }

        return  (int)(answer/=jobs.length);
    }
}
