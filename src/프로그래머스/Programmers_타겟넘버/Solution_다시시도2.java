package 프로그래머스.Programmers_타겟넘버;

public class Solution_다시시도2 {
    public static int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);

        return answer;
    }

    private void dfs(int[] numbers, int target, int index, int sum) {
        if(numbers.length <= index) {
            if(sum == target) answer++;
            return;
        }

        numbers[index] *= 1;
        dfs(numbers, target, index+1, sum+numbers[index]);
        numbers[index] *= -1;
        dfs(numbers, target, index+1, sum+numbers[index]);
    }

    public static void main(String[] args) {
        Solution_다시시도2 solution = new Solution_다시시도2();
        solution.solution(new int[]{1,2,1,2}, 2);
    }
}
