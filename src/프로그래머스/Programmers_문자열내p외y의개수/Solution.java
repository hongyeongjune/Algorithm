package 프로그래머스.Programmers_문자열내p외y의개수;

public class Solution {
    public static boolean solution(String s) {
        boolean answer = true;
        int[] count = new int[2];
        s = s.toUpperCase();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'P') count[0]++;
            else if (s.charAt(i) == 'Y') count[1]++;
        }

        if (count[0] != count[1]) return answer = false;

        return answer;
    }
}
