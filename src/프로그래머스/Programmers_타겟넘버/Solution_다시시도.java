package 프로그래머스.Programmers_타겟넘버;

import java.util.Arrays;

public class Solution_다시시도 {
    private static int answer = 0;

    public static int solution(int[] numbers, int target) {

        dfs(numbers, 0, target);

        return answer;
    }

    private static void dfs(int[] numbers, int index, int target) {

        if (index == numbers.length) {
            int sum = Arrays.stream(numbers).sum();
            if (sum == target)
                answer++;
        } else {
            numbers[index] *= 1;
            dfs(numbers, index + 1, target);

            numbers[index] *= -1;
            dfs(numbers, index + 1, target);
        }
    }
}
