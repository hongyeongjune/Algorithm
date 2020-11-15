package 연습문제.같은숫자는싫어;

import java.util.*;

public class Solution {
    public static int[] solution(int[] arr) {
        int[] answer = {};
        List<Integer> result = new ArrayList<>();
        int index = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[index] != arr[i]) {
                result.add(arr[index]);
                index = i;
            }
        }
        result.add(arr[arr.length - 1]);
        answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }

}
