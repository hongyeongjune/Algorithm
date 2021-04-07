package 리트코드.LeetCode_983_MinimumCostForTickets;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int mincostTickets(int[] days, int[] costs) {

        Set<Integer> set = new HashSet<>();
        int[] memo = new int[366];

        for (int day : days) set.add(day);

        return dp(set, memo, 1, costs);
    }

    private int dp(Set<Integer> set, int[] memo, int index, int[] costs) {

        if (index > 365) return 0;

        if (memo[index] != 0) return memo[index];

        int answer;

        if (set.contains(index)) {
            answer = Math.min(dp(set, memo, index + 1, costs) + costs[0],
                    Math.min(dp(set, memo, index + 7, costs) + costs[1], dp(set, memo, index + 30, costs) + costs[2]));
        } else answer = dp(set, memo, index + 1, costs);

        memo[index] = answer;
        return answer;
    }
}
