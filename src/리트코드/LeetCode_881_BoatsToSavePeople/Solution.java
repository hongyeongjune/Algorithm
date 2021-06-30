package 리트코드.LeetCode_881_BoatsToSavePeople;

import java.util.Arrays;

public class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;

        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
                right--;
            } else right--;

            answer++;
        }

        return answer;
    }
}
