package 리트코드.LeetCode_1711_CountGoodMeals;

import java.util.HashMap;

public class Solution {
    public static int MOD = (int) Math.pow(10, 9) + 7;

    public int countPairs(int[] deliciousness) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int food : deliciousness) {
            int pow = 1;
            for (int i = 0; i < 22; i++) {
                answer += map.getOrDefault(pow - food, 0);
                answer %= MOD;
                pow *= 2;
            }
            map.merge(food, 1, Integer::sum);
        }

        return answer;
    }
}
