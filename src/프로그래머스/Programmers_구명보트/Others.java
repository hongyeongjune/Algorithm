package 프로그래머스.Programmers_구명보트;

import java.util.Arrays;

public class Others {
    public static int solution(int[] people, int limit) {
        int answer = 0;

        int low = 0, high = people.length -1;

        Arrays.sort(people);

        while(low <= high) {
            if(people[low] + people[high] <= limit)
                low++;
            high--;
            answer++;
        }

        return answer;
    }
}
