package 리트코드.LeetCode_646_MaximumLengthOfPairChain;

import java.util.Arrays;

public class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (o1, o2) -> o1[1] - o2[1]);

        int last = Integer.MIN_VALUE;
        int answer = 0;

        for (int[] pair : pairs) {
            if (last < pair[0]) {
                last = pair[1];
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.findLongestChain(new int[][]{
                {-6, 9}, {1, 6}, {8, 10}, {-1, 4}, {-6, -2}, {-9, 8}, {-5, 3}, {0, 3}
        });
    }
}
