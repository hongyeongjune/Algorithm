package 우아한테크코스.프로그래밍2;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public long[] solution(String s, String op) {
        List<Long> answers = new ArrayList<>();

        for (int i = 0; i < s.length() - 1; i++) {
            long temp1 = Long.parseLong(s.substring(0, i + 1));
            long temp2 = Long.parseLong(s.substring(i + 1, s.length()));


            switch (op) {
                case "+":
                    answers.add(temp1 + temp2);
                    break;
                case "-":
                    answers.add(temp1 - temp2);
                    break;
                case "*":
                    answers.add(temp1 * temp2);
                    break;
            }
        }

        long[] answer = new long[answers.size()];
        for (int i = 0; i < answer.length; i++) answer[i] = answers.get(i);

        return answer;
    }
}
