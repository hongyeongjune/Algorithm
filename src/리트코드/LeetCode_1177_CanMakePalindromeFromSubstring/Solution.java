package 리트코드.LeetCode_1177_CanMakePalindromeFromSubstring;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int[][] count = new int[s.length() + 1][26];

        for (int i = 0; i < s.length(); i++) {
            count[i + 1] = count[i].clone();
            count[i + 1][s.charAt(i) - 'a']++;
        }

        List<Boolean> answer = new ArrayList<>();
        for (int[] query : queries) {
            int sum = 0;
            for (int i = 0; i < 26; i++) {
                sum += (count[query[1] + 1][i] - count[query[0]][i]) % 2;
            }
            answer.add(sum / 2 <= query[2]);
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.canMakePaliQueries("abcda", new int[][]{
                {3, 3, 0}, {1, 2, 0}, {0, 3, 1}, {0, 3, 2}, {0, 4, 1}
        });
    }
}
