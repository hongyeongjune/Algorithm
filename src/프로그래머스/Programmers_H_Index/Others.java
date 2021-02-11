package 프로그래머스.Programmers_H_Index;

import java.util.Arrays;

public class Others {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int max = 0;
        for(int i = citations.length-1; i > -1; i--){
            int min = (int)Math.min(citations[i], citations.length - i);
            if(max < min) max = min;
        }

        return max;
    }
}
