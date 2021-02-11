package 프로그래머스.Programmers_숫자의표현;

public class Solution {
    public static int solution(int n) {
        int answer = 0;

        for (int i = 0; i <= (n / 2); i++) {
            if (count(i, n)) answer++;
        }

        return answer + 1;
    }

    public static boolean count(int index, int n) {

        int sum = 0;

        do {
            index++;
            sum += index;
        } while (sum < n);

        if (sum == n) return true;
        else return false;

    }
}
