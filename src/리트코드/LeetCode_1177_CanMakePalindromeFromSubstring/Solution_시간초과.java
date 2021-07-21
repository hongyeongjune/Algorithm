package 리트코드.LeetCode_1177_CanMakePalindromeFromSubstring;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution_시간초과 {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> answer = new ArrayList<>();
        for (int[] query : queries) {
            answer.add(canMakePalindromeCheck(s, query[0], query[1], query[2]));
        }

        return answer;
    }

    private Boolean canMakePalindromeCheck(String s, int start, int end, int k) {
        if (k >= 13) {
            return true;
        }
        Set<Character> set = new HashSet<>();
        for (int i = start; i <= end; i++) {
            if (!set.add(s.charAt(i))) set.remove(s.charAt(i));
        }

        return k >= set.size() / 2;
    }
}
