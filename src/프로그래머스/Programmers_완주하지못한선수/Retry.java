package 프로그래머스.Programmers_완주하지못한선수;

import java.util.Arrays;

public class Retry {
    public static String solution(String[] participant, String[] completion) {
        String answer = "";

        Arrays.sort(participant);
        Arrays.sort(completion);

        int index = 0;

        for (int i = 0; i < completion.length; i++) {
            if (!participant[index].equals(completion[i])) {
                answer = participant[index];
                break;
            }
            index++;

            if (index == completion.length) answer = participant[index];
        }

        return answer;
    }

}
