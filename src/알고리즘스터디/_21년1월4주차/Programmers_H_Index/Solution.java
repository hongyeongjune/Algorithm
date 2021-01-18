package 알고리즘스터디._21년1월4주차.Programmers_H_Index;

import java.util.Arrays;

public class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int answer = 0;
        for (int i = citations.length - 1; i >= 0; i--) {
            int min = Math.min(citations[i], citations.length - i);
            answer = Math.max(answer, min);
        }

        return answer;
    }
}
