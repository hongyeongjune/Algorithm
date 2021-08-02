package 리트코드.LeetCode_137_SingleNumberII;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }

        for (int key : map.keySet()) {
            if (map.get(key) == 1) return key;
        }

        return 0;
    }
}
