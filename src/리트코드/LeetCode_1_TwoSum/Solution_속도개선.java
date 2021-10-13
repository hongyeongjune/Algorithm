package 리트코드.LeetCode_1_TwoSum;

import java.util.HashMap;
import java.util.Map;

public class Solution_속도개선 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int remain = target - num;
            if (map.containsKey(remain)) {
                return new int[]{map.get(remain), i};
            }
            map.put(num, i);
        }

        return new int[2];
    }
}
