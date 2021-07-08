package 리트코드.LeetCode_921_MinimumAddToMakeParenthesesValid;

import java.util.Stack;

public class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(c);
            else if (c == ')' && stack.isEmpty())
                sb.append(c);
            else if (c == ')' && stack.peek() == '(')
                stack.pop();
        }

        return sb.toString().length() + stack.size();
    }
}
