package 프로그래머스.Programmers_튜플;

import java.util.*;

public class Solution_다시시도 {
    public int[] solution(String s) {
        s = s.substring(2, s.length() - 2);
        String[] split = s.split("},\\{");
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < split.length; i++) {
            String str = "";
            List<Integer> temp = new ArrayList<>();
            for (char c : split[i].toCharArray()) {
                if (Character.isDigit(c)) {
                    str += String.valueOf(c);
                } else if (!Character.isDigit(c) && !str.isBlank()) {
                    temp.add(Integer.parseInt(str));
                    str = "";
                }
            }
            if (!str.isBlank()) temp.add(Integer.parseInt(str));
            list.add(temp);
        }

        Collections.sort(list, (list1, t1) -> list1.size() - t1.size());

        List<Integer> answer = new ArrayList<>();
        answer.add(list.get(0).get(0));
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.get(i + 1).size(); j++) {
                if (!list.get(i).contains(list.get(i + 1).get(j))) {
                    answer.add(list.get(i + 1).get(j));
                }
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
