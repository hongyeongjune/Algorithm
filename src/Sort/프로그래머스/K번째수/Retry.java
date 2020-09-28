package Sort.프로그래머스.K번째수;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Retry {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            List<Integer> temp = new ArrayList<>();

            for (int j = commands[i][0] - 1; j < commands[i][1]; j++) {
                temp.add(array[j]);
            }

            Collections.sort(temp);
            answer[i] = temp.get(commands[i][2] - 1);
        }

        return answer;
    }

}
