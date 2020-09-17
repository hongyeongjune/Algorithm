package 연습문제.나라의숫자124;

public class Solution {

    public String reverse(String s) {
        return (new StringBuffer(s)).reverse().toString();
    }

    public String solution(int n) {
        String answer = "";
        String[] number = {"4", "1", "2"};

        while (n > 0) {
            int temp = n % 3;

            n /= 3;

            if (temp == 0) {
                answer += number[0];
                n -= 1;
            } else if (temp == 1) answer += number[1];
            else if (temp == 2) answer += number[2];
        }

        return reverse(answer);

    }
}
