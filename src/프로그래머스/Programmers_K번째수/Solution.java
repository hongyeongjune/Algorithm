package 프로그래머스.Programmers_K번째수;

import java.util.Arrays;

public class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i=0; i<commands.length; i++) {
            int index = 0;
            int[] sort = new int[commands[i][1] - commands[i][0]+1];
            for(int j=commands[i][0]-1; j<commands[i][1]; j++) {
                sort[index++] = array[j];
            }

            Arrays.sort(sort);
            answer[i] = sort[commands[i][2]-1];
        }
        return answer;
    }
}
