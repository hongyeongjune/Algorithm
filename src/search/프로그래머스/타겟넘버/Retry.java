package search.프로그래머스.타겟넘버;

public class Retry {

    private static int answer = 0;

    public static int solution(int[] numbers, int target) {

        dfs(numbers, 0, target);

        return answer;
    }

    private static void dfs(int[] numbers, int index, int target) {

        if (index == numbers.length) {
            int sum = 0;
            for (int number : numbers)
                sum += number;
            if (sum == target) answer++;
        } else {
            numbers[index] *= 1;
            dfs(numbers, index + 1, target);

            numbers[index] *= -1;
            dfs(numbers, index + 1, target);
        }
    }
}
