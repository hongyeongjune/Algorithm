package 프로그래머스.Programmers_표편집;

import java.util.Stack;

public class Solution {
    public String solution(int n, int k, String[] cmd) {
        Stack<Integer> stack = new Stack<>();
        int length = n;

        for (String c : cmd) {
            String[] split = c.split(" ");

            if (split[0].equals("U")) {
                k -= Integer.parseInt(split[1]);
            } else if (split[0].equals("D")) {
                k += Integer.parseInt(split[1]);
            } else if (split[0].equals("C")) {
                stack.push(k);
                length--;
                if (k == length) k--;
            } else {
                int value = stack.pop();
                if (k >= value) k++;
                length++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append("O");
        }
        while (!stack.isEmpty()) {
            sb.insert(stack.pop(), "X");
        }

        return sb.toString();
    }
}
