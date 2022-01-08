package 프로그래머스.Programmers_모의고사;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution_다시시도 {

    public static int[] one = {1,2,3,4,5};
    public static int[] two = {2,1,2,3,2,4,2,5};
    public static int[] three = {3,3,1,1,2,2,4,4,5,5};

    public int[] solution(int[] answers) {
        int oneAnswer = 0;
        int twoAnswer = 0;
        int threeAnswer = 0;
        for(int i=0; i<answers.length; i++) {
            if(answers[i] == one[i%5]) {
                oneAnswer++;
            }
            if(answers[i] == two[i%8]) {
                twoAnswer++;
            }
            if(answers[i] == three[i%10]) {
                threeAnswer++;
            }
        }

        int max = Math.max(oneAnswer, Math.max(twoAnswer, threeAnswer));
        List<Integer> answer = new ArrayList<>();
        if(max == oneAnswer) answer.add(1);
        if(max == twoAnswer) answer.add(2);
        if(max == threeAnswer) answer.add(3);
        Collections.sort(answer);

        return answer.stream().mapToInt(value -> value.intValue()).toArray();
    }
}
