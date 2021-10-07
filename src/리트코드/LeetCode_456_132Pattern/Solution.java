package 리트코드.LeetCode_456_132Pattern;

import java.util.Stack;

public class Solution {
    public boolean find132pattern(int[] nums) {

        int num3 = Integer.MIN_VALUE;

        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (num3 > nums[i]) return true;
            else {
                while (!stack.isEmpty() && stack.peek() < nums[i]) {
                    num3 = stack.pop();
                }
            }
            stack.push(nums[i]);
        }

        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.find132pattern(new int[]{-2, 1, 2, -2, 1, 2});
    }
}
