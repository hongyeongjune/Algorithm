package 프로그래머스.Programmers_JadenCase문자열만들기;

public class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                if (temp.length() != 0) {
                    answer.append(temp.toString().substring(0, 1).toUpperCase() + temp.toString().substring(1).toLowerCase());
                    temp.delete(0, temp.length());
                }
                answer.append(' ');
            } else {
                temp.append(c);
            }
        }

        if (temp.length() != 0) {
            answer.append(temp.toString().substring(0, 1).toUpperCase() + temp.toString().substring(1).toLowerCase());
        }

        return answer.toString();
    }
}
