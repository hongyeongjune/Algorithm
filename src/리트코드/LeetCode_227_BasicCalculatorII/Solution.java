package 리트코드.LeetCode_227_BasicCalculatorII;

import java.util.Stack;

public class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int digit = 0;
        char operation = '+';
        for (char c : (s + "+").toCharArray()) {
            if (c == ' ') continue;
            if (Character.isDigit(c)) {
                digit = (digit * 10) + Character.digit(c, 10);
            } else {
                switch (operation) {
                    case '+':
                        stack.push(digit);
                        break;
                    case '-':
                        stack.push(digit * -1);
                        break;
                    case '*':
                        stack.push(stack.pop() * digit);
                        break;
                    case '/':
                        stack.push(stack.pop() / digit);
                        break;
                }
                digit = 0;
                operation = c;
            }
        }
        int answer = 0;
        while (!stack.isEmpty()) {
            answer += stack.pop();
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.calculate("3+2*2");
    }
}
