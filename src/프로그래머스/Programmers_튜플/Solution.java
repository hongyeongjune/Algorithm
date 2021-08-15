package 프로그래머스.Programmers_튜플;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[] solution(String s) {
        s = s.replace("},{", "-");
        s = s.replace("{{", "");
        s = s.replace("}}", "");
        String[] split = s.split("-");
        Arrays.sort(split, (o1, o2) -> o1.length() - o2.length());

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            String[] arr = split[i].split(",");
            for (int j = 0; j < arr.length; j++) {
                if (!list.contains(Integer.parseInt(arr[j]))) {
                    list.add(Integer.parseInt(arr[j]));
                }
            }
        }
        Integer[] answer = list.toArray(new Integer[list.size()]);
        return Arrays.stream(answer).mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution("{{1,2,3},{2,1},{1,2,4,3},{2}}");
    }
}
