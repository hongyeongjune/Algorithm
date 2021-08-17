package 리트코드.LeetCode_997_FindTheTownJudge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int findJudge(int n, int[][] trust) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int[] t : trust) {
            map.computeIfAbsent(t[0], key -> new ArrayList<>()).add(t[1]);
        }

        int judge = -1;

        for (int key : map.keySet()) {
            if (map.get(key).size() == 0) judge = key;
        }

        for (int key : map.keySet()) {
            if (key != judge && !map.get(key).contains(judge)) {
                return -1;
            }
        }

        return judge;
    }
}
