package 프로그래머스.Programmers_124나라의숫자;

public class Solution {
    public String solution(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        while(n > 0) {
            int mod = n % 3;
            n /= 3;
            if(mod == 0) {
                mod = 4;
                n -= 1;
            }
            stringBuilder.append(mod);
        }

        return stringBuilder.reverse().toString();
    }
}
