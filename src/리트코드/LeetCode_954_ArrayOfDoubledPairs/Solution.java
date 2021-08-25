package 리트코드.LeetCode_954_ArrayOfDoubledPairs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean canReorderDoubled(int[] arr) {
        Arrays.sort(arr);
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : arr) {
            map.merge(a, 1, Integer::sum);
        }

        for (int key : arr) {
            if (map.get(key) == 0) continue;
            if (key < 0 && key % 2 != 0) return false;
            int calKey = key > 0 ? key * 2 : key / 2;
            if (map.getOrDefault(key, 0) == 0) return false;
            map.put(key, map.get(key) - 1);
            map.put(key, map.get(calKey) - 1);
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.canReorderDoubled(new int[]{
                4, -2, 2, -4
        });
    }
}
