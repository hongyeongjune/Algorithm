package 프로그래머스.Programmers_삼진법뒤집기;

public class Solution {
    public static int solution(int n) {
        int answer = 0;

        String third = Integer.toString(n, 3);
        StringBuffer stringBuffer = new StringBuffer(third);
        String reverse = stringBuffer.reverse().toString();

        int count = 0;

        for (int i = 0; i < reverse.length(); i++) {
            if (reverse.charAt(i) == 0) count++;
            else break;
        }

        return answer = Integer.parseInt(reverse.substring(count), 3);
    }

}
