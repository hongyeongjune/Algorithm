package 프로그래머스.Programmers_포켓몬;

import java.util.HashMap;

public class Solution {
    public static int solution(int[] nums) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int num : nums) {
            if (hashMap.get(num) == null) {
                hashMap.put(num, 1);
            } else hashMap.put(num, hashMap.get(num) + 1);
        }

        if (nums.length / 2 <= hashMap.size()) return nums.length / 2;
        else return hashMap.size();

    }

}
