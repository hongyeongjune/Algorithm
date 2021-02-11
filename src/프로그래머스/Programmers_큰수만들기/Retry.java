package 프로그래머스.Programmers_큰수만들기;

import java.util.Stack;

public class Retry {
    public static String solution(String number, int k) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < number.length(); i++) {

            while (!stack.isEmpty() && k > 0 && stack.peek() < number.charAt(i)) {
                k--;
                stack.pop();
            }

            stack.push(number.charAt(i));
        }

        System.out.println(stack);

        StringBuilder stringBuilder = new StringBuilder();

        while (!stack.isEmpty()) {
            if (k != 0) {
                k--;
                stack.pop();
            } else {
                stringBuilder.append(stack.pop());
            }
        }

        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        solution("4177252841", 4);
    }

}
