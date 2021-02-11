package 프로그래머스.Programmers_문자열다루기기본;

public class Solution {
    public boolean solution(String s) {

        if (s.length() == 4 || s.length() == 6) {
            for (Character c : s.toCharArray()) {
                if (!Character.isDigit(c)) return false;
            }
        } else return false;


        return true;
    }
}
