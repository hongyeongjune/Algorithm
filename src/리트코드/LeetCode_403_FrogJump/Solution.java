package 리트코드.LeetCode_403_FrogJump;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean canCross(int[] stones) {
        if (stones[1] != 1) return false;
        Set<Integer> stoneList = new HashSet<>();
        for (int stone : stones) {
            stoneList.add(stone);
        }
        int lastStone = stones[stones.length - 1];
        return dfs(stoneList, 1, 0, lastStone);
    }

    private boolean dfs(Set<Integer> stoneList, int units, int index, int lastStone) {
        if (units + index - 1 == lastStone || units + index == lastStone || units + index + 1 == lastStone)
            return true;

        if (units > 1 && stoneList.contains(units + index - 1)) {
            if (dfs(stoneList, units - 1, units + index - 1, lastStone)) return true;
        }
        if (stoneList.contains(units + index)) {
            if (dfs(stoneList, units, units + index, lastStone)) return true;
        }
        if (stoneList.contains(units + index + 1)) {
            if (dfs(stoneList, units + 1, units + index + 1, lastStone)) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.canCross(new int[]{0, 1, 3, 6, 7});
    }
}
