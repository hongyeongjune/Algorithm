package 리트코드.LeetCode_1249_MinimumRemoveToMakeValidParentheses;

import java.util.Stack;

public class Solution {
    public String minRemoveToMakeValid(String s) {

        StringBuilder stringBuilder = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
                stringBuilder.append(c);
            } else if (c == ')' && stack.isEmpty()) continue;
            else if (c == ')' && stack.peek() == '(') {
                stack.pop();
                stringBuilder.append(c);
            } else stringBuilder.append(c);
        }

        while (!stack.isEmpty()) {
            int index = stringBuilder.lastIndexOf(stack.pop().toString());
            stringBuilder.deleteCharAt(index);
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.minRemoveToMakeValid("lee(t(c)o)de)");
        solution.minRemoveToMakeValid("a)b(c)d");
        solution.minRemoveToMakeValid("))((");
        solution.minRemoveToMakeValid("(a(b(c)d)");

    }
}
