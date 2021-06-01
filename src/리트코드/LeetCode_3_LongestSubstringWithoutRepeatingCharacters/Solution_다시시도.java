package 리트코드.LeetCode_3_LongestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;
import java.util.Map;

public class Solution_다시시도 {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int length = 0;
        int answer = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (left <= right && right < s.length()) {
            if (!map.containsKey(s.charAt(right))) {
                map.put(s.charAt(right), 1);
                right++;
                length++;
            } else {
                length--;
                map.remove(s.charAt(left));
                left++;
            }
            answer = Math.max(answer, length);
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution_다시시도 solution_다시시도 = new Solution_다시시도();
        solution_다시시도.lengthOfLongestSubstring("pwwkew");
    }
}
