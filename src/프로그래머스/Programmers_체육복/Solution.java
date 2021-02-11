package 프로그래머스.Programmers_체육복;

public class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] numbers = new int[n+2];

        for(int i=0; i<lost.length; i++) {
            numbers[lost[i]] = 1;
        }

        for(int i=0; i<reserve.length; i++) {

            if(numbers[reserve[i]] == 1 ) numbers[reserve[i]] = 0;
            else numbers[reserve[i]] = 2;

        }

        for(int i=1; i<=n; i++) {
            if(numbers[i] == 0 || numbers[i] == 2)
                answer++;
            else if(numbers[i] == 1 && numbers[i-1] == 2 && i-1 != 0) {
                answer++;
                numbers[i-1] = 0;
                numbers[i] = 0;
            }
            else if(numbers[i] == 1 && numbers[i+1] == 2 && i+1 != n+1) {
                answer++;
                numbers[i+1] = 0;
                numbers[i] = 0;
            }
        }

        return answer;
    }
}
