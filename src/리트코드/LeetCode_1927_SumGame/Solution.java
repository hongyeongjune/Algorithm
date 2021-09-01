package 리트코드.LeetCode_1927_SumGame;

public class Solution {
    public boolean sumGame(String num) {
        int length = num.length();
        double answer = 0;
        for (int i = 0; i < num.length(); i++) {
            answer += (i < length / 2 ? 1 : -1) * (num.charAt(i) == '?' ? 4.5 : num.charAt(i) - '0');
        }

        return answer != 0;
    }
}
