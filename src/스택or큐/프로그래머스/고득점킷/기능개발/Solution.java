package 스택or큐.프로그래머스.고득점킷.기능개발;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        int[] days = new int[progresses.length];

        List<Integer> answers = new ArrayList<>();

        for(int i=0; i<progresses.length; i++) {

            int count = 0;

            while(progresses[i] < 100) {
                progresses[i] += speeds[i];
                count++;
            }

            days[i] = count;
        }



        return answer;
    }
}
