package 리트코드.LeetCode_754_ReachANumber;

public class Solution {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int sum = 0, step = 0;
        while (sum < target || (sum - target) % 2 != 0) {
            step++;
            sum += step;
        }
        return step;
    }
}
