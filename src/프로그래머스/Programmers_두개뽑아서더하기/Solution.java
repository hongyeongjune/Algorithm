package 프로그래머스.Programmers_두개뽑아서더하기;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class Solution {
    public int[] solution(int[] numbers) {
        HashSet<Integer> hashSet = new HashSet<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (i != j) {
                    hashSet.add(numbers[i] + numbers[j]);
                }
            }
        }

        Iterator<Integer> iterator = hashSet.iterator();
        int[] answer = new int[hashSet.size()];
        int index = 0;
        while (iterator.hasNext()) {
            answer[index] = iterator.next();
            index++;
        }

        Arrays.sort(answer);
        return answer;
    }
}
