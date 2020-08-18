package greedy.프로그래머스.큰수만들기;

import java.util.Stack;

public class Solution {
    public String solution(String number, int k) {

        Stack<Character> stack = new Stack<>();
        for(int i=0; i<number.length(); i++) {

            while(!stack.isEmpty() && k > 0 && stack.peek() < number.charAt(i)) {
                k--;
                stack.pop();
            }

            stack.push(number.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        // k개를 삭제하지 못 한 경우 뒤에서 부터 제거.
        while(!stack.isEmpty()) {
            if (k != 0) {
                stack.pop();
                k--;
            } else {
                sb.append(stack.pop());
            }
        }


        return sb.reverse().toString();
    }
}
