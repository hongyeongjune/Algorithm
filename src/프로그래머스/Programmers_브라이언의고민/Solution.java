package 프로그래머스.Programmers_브라이언의고민;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public String solution(String sentence) {
        try {
            Deque<Character> deque = new ArrayDeque<>();
            int[] used = new int[26];

            for (char c : sentence.toCharArray()) {
                if (!Character.isLetter(c)) return "invalid";
                deque.offer(c);
                if (Character.isLowerCase(c)) used[c - 'a']++;
            }

            Deque<Character> word = new ArrayDeque<>();
            String answer = "";

            while (!deque.isEmpty()) {
                char first = deque.poll();
                if (Character.isLowerCase(first)) {
                    if (used[first - 'a'] != 2) return "invalid";
                    if (Character.isLowerCase(deque.peek())) return "invalid";
                    word.offer(deque.poll());
                    char second = deque.poll();
                    if (Character.isLowerCase(second) && first != second) {
                        for (int i = 0; i < used[second - 'a'] - 1; i++) {
                            if (Character.isLowerCase(deque.peek())) return "invalid";
                            word.offer(deque.poll());
                            if (deque.poll() != second) return "invalid";
                        }
                        if (Character.isLowerCase(deque.peek())) return "invalid";
                        word.offer(deque.poll());
                        if (deque.poll() != first) return "invalid";
                    } else if (first != second) {
                        word.offer(second);
                        while (deque.peek() != first) {
                            if (Character.isLowerCase(deque.peek())) return "invalid";
                            word.offer(deque.poll());
                        }
                        deque.poll();
                    }
                } else {
                    word.offer(first);
                    if (deque.isEmpty()) {
                        return answer + word.poll();
                    }
                    char second = deque.poll();
                    if (Character.isLowerCase(second)) {
                        if (used[second - 'a'] == 2) {
                            deque.offerFirst(second);
                        } else {
                            for (int i = 0; i < used[second - 'a'] - 1; i++) {
                                if (Character.isLowerCase(deque.peek())) return "invalid";
                                word.offer(deque.poll());
                                if (deque.poll() != second) return "invalid";
                            }
                            if (Character.isLowerCase(deque.peek())) return "invalid";
                            word.offer(deque.poll());
                        }
                    } else {
                        word.offer(second);
                        if (deque.isEmpty()) {
                            return answer + word.poll() + word.poll();
                        }
                        while (!deque.isEmpty() && Character.isUpperCase(deque.peek())) {
                            word.offer(deque.poll());
                        }
                        if (!deque.isEmpty() && used[deque.peek() - 'a'] != 2) {
                            deque.offerFirst(word.pollLast());
                        }
                    }
                }

                while (!word.isEmpty()) {
                    answer += word.poll();
                }

                if (!deque.isEmpty()) answer += " ";
            }

            return answer;
        } catch (Exception e) {
            return "invalid";
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String test1 = solution.solution("HELLO WORLD");
        String test2 = solution.solution("SpIpGpOpNpGJqOqA");
        String test3 = solution.solution("AbAaAbAaCa");
        String test4 = solution.solution("aIaAM");
        String test5 = solution.solution("AAAaBaAbBBBBbCcBdBdBdBcCeBfBeGgGGjGjGRvRvRvRvRvR");
        String test6 = solution.solution("aaA");
        String test7 = solution.solution("Aaa");
        String test8 = solution.solution("HaEaLaLaOWaOaRaLaD");
        String test9 = solution.solution("aHELLOWORLDa");
        String test10 = solution.solution("HaEaLaLObWORLDb");
        String test11 = solution.solution("HaEaLaLaObWORLDb");
        String test12 = solution.solution("aHbEbLbLbOacWdOdRdLdDc");
        String test13 = solution.solution("abAba");
        String test14 = solution.solution("xAaAbAaAx");
        String test15 = solution.solution("AbAaAbAaCa");
        String test16 = solution.solution("AbAaAbAaC");
    }
}
