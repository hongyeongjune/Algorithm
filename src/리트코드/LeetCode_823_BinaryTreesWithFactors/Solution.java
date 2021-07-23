package 리트코드.LeetCode_823_BinaryTreesWithFactors;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static long MOD = 1000000007;

    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        long answer = 0L;
        Map<Integer, Long> memoization = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            memoization.put(arr[i], 1L);
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0) {
                    memoization.put(arr[i], (memoization.get(arr[i]) + memoization.get(arr[j]) * memoization.getOrDefault(arr[i] / arr[j], 0L)) % MOD);
                }
            }
            answer = (answer + memoization.get(arr[i])) % MOD;
        }

        return (int) answer;
    }
}
