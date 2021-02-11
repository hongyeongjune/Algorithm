package 프로그래머스.Programmers_내적;

public class Solution {
    public static int solution(int[] a, int[] b) {
        int answer = 0;
        for (int i = 0; i < a.length; i++) {
            answer += (a[i] * b[i]);
        }
        return answer;
    }
}