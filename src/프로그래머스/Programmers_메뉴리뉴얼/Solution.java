package 프로그래머스.Programmers_메뉴리뉴얼;


import java.util.*;

public class Solution {

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
                dfs(menu[j], 0, menu[j].length(), course[i], "");
            }
        }

        int[] max = new int[course[course.length - 1] + 1];

        for (String key : map.keySet()) {
            if (map.get(key) >= 2) {
                if (max[key.length()] < map.get(key)) max[key.length()] = map.get(key);
            }
        }

        List<String> answer = new ArrayList<>();
        for (String key : map.keySet()) {
            if (map.get(key) >= 2 && max[key.length()] == map.get(key)) answer.add(key);
        }

        Collections.sort(answer);

        String[] result = new String[answer.size()];

        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }

        return result;
    }

    private void dfs(String order, int index, int length, int course, String result) {

        if (course == 0) {
            map.merge(result, 1, Integer::sum);
            return;
        }


        for (int i = index; i < length; i++) {
            dfs(order, i + 1, length, course - 1, result + order.charAt(i));
        }
    }
}
