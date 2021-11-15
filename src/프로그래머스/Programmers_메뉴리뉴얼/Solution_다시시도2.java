package 프로그래머스.Programmers_메뉴리뉴얼;

import java.util.*;

public class Solution_다시시도2 {

    public static Map<String, Integer> map = new HashMap<>();

    public String[] solution(String[] orders, int[] course) {
        String[] menu = new String[orders.length];

        for(int i=0; i<orders.length; i++) {
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            menu[i] = new String(arr);
        }

        for(int c : course) {
            for(String m : menu) {
                dfs(m, c, "", 0);
            }
        }

        int[] max = new int[course[course.length-1]+1];
        for(String key : map.keySet()) {
            if(map.get(key) >= 2) max[key.length()] = Math.max(max[key.length()], map.get(key));
        }

        List<String> answer = new ArrayList<>();
        for(String key : map.keySet()) {
            if(map.get(key) == max[key.length()]) answer.add(key);
        }
        Collections.sort(answer);

        return answer.toArray(new String[answer.size()]);
    }

    private void dfs(String order, int course, String menu, int index) {
        if(course == 0) {
            map.merge(menu, 1, Integer::sum);
            return;
        }

        for(int i=index; i<order.length(); i++) {
            dfs(order, course-1, menu + order.charAt(i), i+1);
        }
    }

    public static void main(String[] args) {
        Solution_다시시도2 solution = new Solution_다시시도2();
        solution.solution(new String[]{
                "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"
        }, new int[]{
                2,3,4
        });
    }
}
