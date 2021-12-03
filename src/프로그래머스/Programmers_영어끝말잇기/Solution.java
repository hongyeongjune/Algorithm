package 프로그래머스.Programmers_영어끝말잇기;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};

        Set<String> set = new HashSet<>();
        String word = words[0];
        set.add(word);

        for(int i=1; i<words.length; i++) {
            if(word.charAt(word.length()-1) != words[i].charAt(0) || set.contains(words[i])) {
                return new int[]{i%n+1, i/n+1};
            }
            word = words[i];
            set.add(word);
        }

        return answer;
    }
}
