package 프로그래머스.Programmers_H_Index;

import java.util.Arrays;
import java.util.Collections;

/**
 * 알고리즘 사고 => 정답
 * 알고리즘 코딩 => 오답
 */
public class Solution {
    public int solution(int[] citations) {
        int answer = 0;

        Integer[] sortCitations = new Integer[citations.length];
        for(int i=0; i<citations.length; i++) {
            sortCitations[i] = citations[i];
        }

        Arrays.sort(sortCitations, Collections.reverseOrder());

        int count = 0;

        if(sortCitations[0] == 0)
            return answer = 0;

        for(int i=0; i<sortCitations.length-1; i++) {
            count = 0;
            for (int j = i+1; j < sortCitations.length; j++) {
                if (sortCitations[i] == sortCitations[j]) {
                    count++;
                    if (count >= sortCitations[i])
                        return answer = count;
                }
            }
        }

        for(int i=0; i<sortCitations.length; i++) {
            if(i > sortCitations[i])
                return answer = i;
            if(sortCitations.length == 1 && sortCitations[i] != 0)
                return answer = 1;
        }

        if(sortCitations[sortCitations.length-1] > sortCitations.length)
            return answer = sortCitations.length;

        return answer;
    }
}
