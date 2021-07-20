package 리트코드.LeetCode_746_MinCostClimbingStairs;

public class Solution {
    public int minCostClimbingStairs(int[] cost) {
        for (int i = 2; i < cost.length; i++) {
            cost[i] += Math.min(cost[i - 1], cost[i - 2]);
        }
        return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.minCostClimbingStairs(new int[]{
                1, 100, 1, 1, 1, 100, 1, 1, 100, 1
        });
    }
}
