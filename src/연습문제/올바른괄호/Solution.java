package 연습문제.올바른괄호;

import java.util.Stack;

public class Solution {
    public static boolean solution(String s) {
        boolean answer = false;

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek().equals('(') && c == ')') {
                stack.pop();
                continue;
            }
            stack.push(c);
        }

        if (stack.isEmpty()) return answer = true;
        return answer;
    }
}
