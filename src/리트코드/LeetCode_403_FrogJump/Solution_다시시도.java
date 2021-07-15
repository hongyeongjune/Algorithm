package 리트코드.LeetCode_403_FrogJump;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution_다시시도 {
    public boolean canCross(int[] stones) {
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int i = 1; i < stones.length; i++)
            map.put(stones[i], new HashSet<>());

        if (stones[0] + 1 == stones[1]) {
            map.computeIfAbsent(stones[1], key -> new HashSet<>()).add(1);
        }

        for (int i = 1; i < stones.length; i++) {
            for (int unit : map.get(stones[i])) {
                if (unit > 1 && map.containsKey(stones[i] + unit - 1)) {
                    map.computeIfAbsent(stones[i] + unit - 1, key -> new HashSet<>()).add(unit - 1);
                }
                if (map.containsKey(stones[i] + unit)) {
                    map.computeIfAbsent(stones[i] + unit, key -> new HashSet<>()).add(unit);
                }
                if (map.containsKey(stones[i] + unit + 1)) {
                    map.computeIfAbsent(stones[i] + unit + 1, key -> new HashSet<>()).add(unit + 1);
                }
            }
        }

        return map.get(stones[stones.length - 1]).size() >= 1;
    }
}
