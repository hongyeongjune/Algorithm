package 완전탐색.프로그래머스.모의고사;

import java.util.*;

public class Solution {
    public int[] solution(int[] answers) {
        int[] answer = new int[0];
        int[][] compare = {{1,0}, {2,0}, {3,0}};

        int[] one = new int[answers.length];
        int[] two = new int[answers.length];
        int[] three = new int[answers.length];

        int[] oneRule = {1,2,3,4,5};
        int oneIndex = 0;

        int[] twoRule = {2,1,2,3,2,4,2,5};
        int twoIndex = 0;

        int[] threeRule = {3,3,1,1,2,2,4,4,5,5};
        int threeIndex = 0;

        for(int i=0; i<answers.length; i++) {
            one[i] = oneRule[oneIndex++];
            if(oneIndex == 5) oneIndex = 0;

            two[i] = twoRule[twoIndex++];
            if(twoIndex == 8) twoIndex = 0;

            three[i] = threeRule[threeIndex++];
            if(threeIndex == 10) threeIndex = 0;
        }

        for(int i=0; i<answers.length; i++) {
            if(answers[i] == one[i]) compare[0][1]++;
            if(answers[i] == two[i]) compare[1][1]++;
            if(answers[i] == three[i]) compare[2][1]++;
        }

        Arrays.sort(compare, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });

        if(compare[0][1] == compare[1][1] && compare[1][1] != compare[2][1]) {
            answer = new int[2];
            answer[0] = compare[0][0];
            answer[1] = compare[1][0];
        }
        else if(compare[0][1] == compare[1][1] && compare[1][1] == compare[2][1]) {
            answer = new int[3];
            answer[0] = compare[0][0];
            answer[1] = compare[1][0];
            answer[2] = compare[2][0];
        }
        else if(compare[0][1] > compare[1][1]) {
            answer = new int[1];
            answer[0] = compare[0][0];
        }

        Arrays.sort(answer);

        return answer;
    }
}
