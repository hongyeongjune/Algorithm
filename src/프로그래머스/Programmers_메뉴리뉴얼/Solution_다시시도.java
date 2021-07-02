package 프로그래머스.Programmers_메뉴리뉴얼;

import java.util.*;

public class Solution_다시시도 {

    public static Map<String, Integer> map = new HashMap<>();

    public String[] solution(String[] orders, int[] course) {
        String[] menu = new String[orders.length];

        for (int i = 0; i < orders.length; i++) {
            char[] temp = orders[i].toCharArray();
            Arrays.sort(temp);
            menu[i] = new String(temp);
        }

        for (int i = 0; i < course.length; i++) {
            for (int j = 0; j < orders.length; j++) {
                dfs(menu[j], course[i], "", menu[j].length(), 0);
            }
        }

        int[] max = new int[course[course.length - 1] + 1];

        for (String key : map.keySet()) {
            if (map.get(key) >= 2) {
                max[key.length()] = Math.max(max[key.length()], map.get(key));
            }
        }

        List<String> answer = new ArrayList<>();
        for (String key : map.keySet()) {
            if (map.get(key) >= 2 && max[key.length()] == map.get(key)) {
                answer.add(key);
            }
        }

        Collections.sort(answer);

        return answer.toArray(new String[answer.size()]);
    }

    private void dfs(String menu, int course, String answer, int length, int index) {

        if (course == 0) {
            map.merge(answer, 1, Integer::sum);
            return;
        }

        for (int i = index; i < length; i++) {
            dfs(menu, course - 1, answer + menu.charAt(i), length, i + 1);
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        String[] orders = {"XYZ", "XWY", "WXA"};
        int[] course = {2, 3, 4};
        String[] strings = solution.solution(orders, course);
        for (String str : strings) {
            System.out.println(str);
        }

    }
}
