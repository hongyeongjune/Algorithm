package 프로그래머스.Programmers_카펫;

public class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};

        for(int i=1; i<yellow; i++) {
            if(yellow%i == 0) {
                int temp = yellow/i;

                if(temp >= i && 2*temp + 2*i + 4 == brown) {
                    answer = new int[2];
                    answer[0] = 2+temp;
                    answer[1] = 2+i;
                    return answer;
                }
            }
        }
        return answer;
    }
}
