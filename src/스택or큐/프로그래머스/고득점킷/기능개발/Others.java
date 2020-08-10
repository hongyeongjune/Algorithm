package 스택or큐.프로그래머스.고득점킷.기능개발;

import java.util.*;

public class Others {
    public int[] solutionAnotherPerson(int[] progresses, int[] speeds) {

        int[] dayOfend = new int[100];
        int day = -1;

        for(int i=0; i<progresses.length; i++) {
            while(progresses[i] + (day*speeds[i]) < 100) {
                day++;
            }
            dayOfend[day]++;
        }

        return Arrays.stream(dayOfend).filter(i -> i!=0).toArray();
    }

    public int[] solutionOtherPerson(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> answerList = new ArrayList<>();

        for (int i = 0; i < speeds.length; i++) {
            double remain = (100 - progresses[i]) / (double) speeds[i];
            int date = (int) Math.ceil(remain);

            if (!q.isEmpty() && q.peek() < date) {
                answerList.add(q.size());
                q.clear();
            }

            q.offer(date);
        }

        answerList.add(q.size());

        int[] answer = new int[answerList.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}
