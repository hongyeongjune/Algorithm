package 스택or큐.프로그래머스.고득점킷.주식가격;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] solution(int[] prices) {

        int[] answer = new int[prices.length];

        for(int i=0; i<prices.length; i++) {
            int count = 0;
            for(int j=i+1; j<prices.length; j++) {
                if(prices[i] <= prices[j]) count++;
                else if(prices[i] > prices[j]) {
                    count++;
                    break;
                }
            }
            answer[i] = count;
        }

        return answer;
    }
}
