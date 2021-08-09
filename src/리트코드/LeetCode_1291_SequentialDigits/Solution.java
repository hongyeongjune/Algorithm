package 리트코드.LeetCode_1291_SequentialDigits;

import java.util.*;

public class Solution {
    public List<Integer> sequentialDigits(int low, int high) {

        List<Integer> answer = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < 10; i++) queue.offer(i);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (low <= current && current <= high) answer.add(current);
            int next = current * 10 + (current % 10) + 1;
            if (current % 10 < 9 && next <= high) queue.offer(next);
        }

        Collections.sort(answer);
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.sequentialDigits(100, 300);
    }
}
