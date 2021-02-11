package 프로그래머스.Programmers_모의고사;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Retry {
    public static int[] solution(int[] answers) {

        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] count = new int[3];

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == a[i % a.length])
                count[0]++;
            if (answers[i] == b[i % b.length])
                count[1]++;
            if (answers[i] == c[i % c.length])
                count[2]++;
        }

        int max = Math.max(count[0], Math.max(count[1], count[2]));
        if (max == count[0]) result.add(1);
        if (max == count[1]) result.add(2);
        if (max == count[2]) result.add(3);
        int[] answer = new int[result.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }

        Arrays.sort(answer);

        return answer;
    }

}
