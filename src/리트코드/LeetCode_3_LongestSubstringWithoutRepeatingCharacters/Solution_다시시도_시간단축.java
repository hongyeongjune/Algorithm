package 리트코드.LeetCode_3_LongestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution_다시시도_시간단축 {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        Set<Character> set = new HashSet<>();
        int answer = 0;

        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
                answer = Math.max(answer, set.size());
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }

        return answer;
    }
}
