package 프로그래머스.Programmers_완주하지못한선수;

import java.util.Arrays;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Arrays.sort(participant);
        Arrays.sort(completion);

        for(int i=0; i<completion.length; i++) {
            if(!participant[i].equals(completion[i]))
                return answer = participant[i];
        }
        return answer = participant[completion.length];
    }
}
