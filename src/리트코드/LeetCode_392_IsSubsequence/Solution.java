package 리트코드.LeetCode_392_IsSubsequence;

public class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.equals("")) return true;

        int index = 0;
        for (char c : t.toCharArray()) {
            if (s.charAt(index) == c) index++;
            if (index == s.length()) return true;
        }

        return false;
    }
}
