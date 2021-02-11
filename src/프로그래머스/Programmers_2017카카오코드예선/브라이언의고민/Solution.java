package 프로그래머스.Programmers_2017카카오코드예선.브라이언의고민;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public static String solution(String sentence) {
        String answer = "";

        Deque<Character> deque = new ArrayDeque<>();
        int[] used = new int[26];

        for (char c : sentence.toCharArray()) {
            deque.offer(c);
            if (Character.isLowerCase(c))
                used[c - 'a']++;
        }

        while (!deque.isEmpty()) {
            char first = deque.poll();
            Deque<Character> word = new ArrayDeque<>();

            if (Character.isLowerCase(first)) {
                if (used[first - 'a'] != 2) return "invalid";
                if (Character.isLowerCase(deque.peek())) return "invalid";
                word.offer(deque.poll());
                char second = deque.poll();

                if (Character.isLowerCase(second) && first != second) {
                    for (int i = 1; i < used[second - 'a']; i++) {
                        if (Character.isLowerCase(deque.peek())) return "invalid";
                        word.offer(deque.poll());
                        if (deque.poll() != second) return "invalid";
                    }
                    if (Character.isLowerCase(deque.peek())) return "invalid";
                    word.add(deque.poll());
                    if (deque.poll() != first) return "invalid";
                } else if (first != second) {
                    word.offer(deque.poll());
                    while (deque.peek() != first) {
                        if (Character.isLowerCase(deque.peek())) return "invalid";
                        word.add(deque.poll());
                    }
                    deque.poll();
                }
            } else {
                word.add(first);
                if (deque.isEmpty()) {
                    return answer + word.poll();
                }
                char second = deque.poll();
                if (Character.isLowerCase(second)) {
                    if (used[second - 'a'] == 2)
                        deque.offerFirst(second);
                    else {
                        for (int i = 1; i < used[second - 'a']; i++) {
                            if (Character.isLowerCase(deque.peek())) return "invalid";
                            word.add(deque.poll());
                            if (deque.poll() != second) return "invalid";
                        }
                        if (Character.isLowerCase(deque.peek())) return "invalid";
                        word.add(deque.poll());
                    }
                } else {
                    word.add(second);
                    if (deque.isEmpty()) {
                        return answer + word.poll() + word.poll();
                    }
                    while (Character.isUpperCase(deque.peek())) {
                        word.add(deque.poll());
                        if (deque.isEmpty()) break;
                    }

                    if (!deque.isEmpty()) {
                        if (used[deque.peek() - 'a'] != 2)
                            deque.addFirst(word.pollLast());
                    }
                }
            }
            while (!word.isEmpty()) {
                answer += word.poll();
            }

            if (!deque.isEmpty()) answer += " ";
        }

        return answer;
    }
}
