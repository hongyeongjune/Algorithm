package 리트코드.LeetCode_678_ValidParenthesisString;

public class Solution {

    public boolean checkValidString(String s) {

        int left = 0;
        int right = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                left++;
                right++;
            } else if (c == ')') {
                left--;
                right--;
            } else if (c == '*') {
                left++;
                right--;
            }

            if (left < 0) return false;
            right = Math.max(right, 0);
        }

        return right == 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.checkValidString("(*)");
    }
}
