package 리트코드.LeetCode_991_BrokenCalculator;

public class Solution {

    public int brokenCalc(int startValue, int target) {

        int count = 0;
        while (target > startValue) {
            target = target % 2 == 0 ? target / 2 : target + 1;
            count++;
        }

        return startValue + count - target;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.brokenCalc(2, 3);
    }
}
