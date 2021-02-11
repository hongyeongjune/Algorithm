package 프로그래머스.Programmers_가장긴팰린드롬;

public class Solution {
    public static int solution(String s) {
        int answer = 0;

        for (int i = s.length(); i > 0; i--) {

            for (int j = 0; j <= s.length() - i; j++) {
                boolean check = true;
                int left = j;
                int right = i - 1 + j;

                for (int k = 0; k < i / 2; k++) {
                    if (s.charAt(left++) != s.charAt(right--)) {
                        check = false;
                        break;
                    }
                }
                if (check) return answer = i;
            }
        }
        return answer;
    }

}
