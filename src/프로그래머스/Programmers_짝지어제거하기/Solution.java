package 프로그래머스.Programmers_짝지어제거하기;

import java.util.Stack;

public class Solution {
    public int solution(String s) {
        int index = 0;

        while (index < s.length()) {
            if (index + 1 < s.length() && s.charAt(index) == s.charAt(index + 1)) {
                String first = s.substring(0, index);
                String second = "";
                if (index + 2 < s.length()) {
                    second = s.substring(index + 2);
                }
                s = first + second;
                if (index - 1 >= 0) index--;
                else index = 0;
                continue;
            }
            index++;
        }
        return s.length() == 0 ? 1 : 0;
    }

    public int solution_시간개선(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && stack.peek() == s.charAt(i)) {
                stack.pop();
            } else stack.push(s.charAt(i));
        }

        return stack.isEmpty() ? 1 : 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution_시간개선(new String("baabaa"));
    }
}
