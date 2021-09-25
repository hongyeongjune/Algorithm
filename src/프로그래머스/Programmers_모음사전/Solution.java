package 프로그래머스.Programmers_모음사전;

public class Solution {
    public static String VOWEL = "AEIOU";
    public static int[] INCREMENT = {781, 156, 31, 6, 1};

    public int solution(String word) {
        int answer = word.length();
        for (int i = 0; i < word.length(); i++) {
            int index = VOWEL.indexOf(word.charAt(i));
            answer += (index * INCREMENT[i]);
        }
        return answer;
    }
}
