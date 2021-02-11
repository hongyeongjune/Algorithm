package 프로그래머스.Programmers_나누어떨어지는숫자배열;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> result = new ArrayList<>();

        for (int a : arr) {
            if (a % divisor == 0) result.add(a);
        }

        if (result.isEmpty()) return new int[]{-1};

        int[] answer = new int[result.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }

        Arrays.sort(answer);

        return answer;
    }
}
