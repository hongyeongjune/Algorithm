package search.프로그래머스.타겟넘버;

public class Solution {
    public static int answer = 0;

    public int solution(int[] numbers, int target) {

        bfsOrDfs(numbers, 0, target);

        return answer;
    }

    public void bfsOrDfs(int[] numbers, int index, int target) {

        if (numbers.length == index) {
            int sum = 0;
            for (int number : numbers)
                sum += number;
            if (sum == target) answer++;
        } else {
            numbers[index] *= 1;
            bfsOrDfs(numbers, index + 1, target);

            numbers[index] *= -1;
            bfsOrDfs(numbers, index + 1, target);
        }
    }
}
