package 리트코드.LeetCode_754_ReachANumber;

import java.util.HashMap;
import java.util.Map;

public class Solution_시간초과 {
    public static int answer;

    public int reachNumber(int target) {
        answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(-1, 1);
        dfs(map, 2, target);
        return answer;
    }

    private void dfs(Map<Integer, Integer> map, int step, int target) {
        if (map.containsKey(target)) {
            answer = map.get(target);
            return;
        }
        Map<Integer, Integer> nextMap = new HashMap<>();
        for (int key : map.keySet()) {
            nextMap.put(key + step, step);
            nextMap.put(key - step, step);
        }
        dfs(nextMap, step + 1, target);
    }

    public static void main(String[] args) {
        Solution_시간초과 solution = new Solution_시간초과();
        solution.reachNumber(2);
    }
}
