package 프로그래머스.Programmers_위장;

import java.util.HashMap;
import java.util.Map;

public class Solution_다시시도 {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();

        for (String[] cloth : clothes) {
            map.merge(cloth[1], 1, Integer::sum);
        }

        int answer = 1;

        for (String key : map.keySet()) {
            answer *= (map.get(key) + 1);
        }

        return answer - 1;
    }
}
