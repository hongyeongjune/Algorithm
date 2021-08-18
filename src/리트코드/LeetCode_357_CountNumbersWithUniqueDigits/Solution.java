package 리트코드.LeetCode_357_CountNumbersWithUniqueDigits;

public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        if (n == 1) return 10;

        int answer = 10;
        int multiply = 9;

        for (int i = 2; i <= n; i++) {
            multiply = multiply * (9 - i + 2);
            answer += multiply;
        }

        return answer;
    }
}
