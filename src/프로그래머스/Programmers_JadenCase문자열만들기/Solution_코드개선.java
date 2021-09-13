package 프로그래머스.Programmers_JadenCase문자열만들기;

public class Solution_코드개선 {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        String[] split = s.toLowerCase().split("");
        boolean flag = true;

        for (String str : split) {
            answer.append(flag ? str.toUpperCase() : str);
            flag = str.equals(" ") ? true : false;
        }

        return answer.toString();
    }
}
