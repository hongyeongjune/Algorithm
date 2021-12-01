package 프로그래머스.Programmers_메뉴리뉴얼;

import java.util.*;

public class Solution_다시시도3 {

    public static Map<String, Integer> map = new HashMap<>();

    public String[] solution(String[] orders, int[] course) {

        for(String order : orders) {
            char[] arr = order.toCharArray();
            Arrays.sort(arr);
            for(int c : course) {
                dfs(arr, c, 0, "", 0);
            }
        }

        int[] max = new int[course[course.length-1]+1];
        for(String key : map.keySet()) {
            if(map.get(key) >= 2)
                max[key.length()] = Math.max(max[key.length()], map.get(key));
        }

        List<String> answer = new ArrayList<>();
        for(String key : map.keySet()) {
            if(map.get(key) == max[key.length()]) answer.add(key);
        }

        Collections.sort(answer);

        return answer.toArray(new String[answer.size()]);
    }

    private void dfs(char[] arr, int course, int index, String order, int count) {

        if(count == course) {
            map.merge(order, 1, Integer::sum);
            return;
        }

        for(int i=index; i<arr.length; i++) {
            dfs(arr, course, i+1, order + arr[i], count+1);
        }
    }

    public static void main(String[] args) {
        Solution_다시시도3 solution_다시시도3 = new Solution_다시시도3();
//        solution_다시시도3.solution(new String[]{
//                "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"
//        }, new int[]{2,3,4});

//        solution_다시시도3.solution(new String[]{
//                "ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"
//        }, new int[]{2,3,5});

        solution_다시시도3.solution(new String[]{
            "XYZ", "XWY", "WXA"
        }, new int[]{4});
    }
}
