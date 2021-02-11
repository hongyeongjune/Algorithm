package 프로그래머스.Programmers_수박수박수박수박수박수;

public class Solution {
    public String solution(int n) {
        String answer = "";
        String su = "수";
        String bak = "박";

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) answer += su;
            else if (i % 2 == 1) answer += bak;
        }

        return answer;
    }
}
