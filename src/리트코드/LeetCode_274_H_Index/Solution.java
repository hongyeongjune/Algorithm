package 리트코드.LeetCode_274_H_Index;

import java.util.Arrays;

public class Solution {
    public int hIndex(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for (int i = citations.length - 1; i >= 0; i--) {
            int min = Math.min(citations[i], citations.length - i);
            answer = Math.max(answer, min);
        }
        return answer;
    }
}
