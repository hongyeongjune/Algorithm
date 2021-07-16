package 프로그래머스.Programmers_카카오인턴_보석쇼핑;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public int[] solution(String[] gems) {
        Set<String> set = new HashSet<>();
        for (String gem : gems) set.add(gem);

        Map<String, Integer> map = new HashMap<>();
        int index = 0;
        int min = Integer.MAX_VALUE;
        int[] answer = new int[2];

        for (int i = 0; i < gems.length; i++) {
            map.merge(gems[i], 1, Integer::sum);

            if (map.size() == set.size()) {
                while (map.get(gems[index]) > 1) {
                    map.merge(gems[index], -1, Integer::sum);
                    index++;
                }
            }

            if (map.size() == set.size() && min > i - index) {
                min = i - index;
                answer[0] = index + 1;
                answer[1] = index + min + 1;
            }
        }

        return answer;
    }
}
