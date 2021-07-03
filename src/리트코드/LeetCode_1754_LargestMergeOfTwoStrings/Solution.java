package 리트코드.LeetCode_1754_LargestMergeOfTwoStrings;

public class Solution {
    public String largestMerge(String word1, String word2) {
        StringBuilder answer = new StringBuilder();

        int left1 = 0;
        int left2 = 0;

        while (left1 < word1.length() || left2 < word2.length()) {
            char c1 = left1 < word1.length() ? word1.charAt(left1) : 0;
            char c2 = left2 < word2.length() ? word2.charAt(left2) : 0;

            if (c1 == c2) {
                if (word1.substring(left1).compareTo(word2.substring(left2)) > 0) {
                    c2 = 0;
                } else c1 = 0;
            }
            if (c1 > c2) {
                answer.append(c1);
                left1++;
            } else {
                answer.append(c2);
                left2++;
            }
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.largestMerge("abcabc", "abdcaba");
    }
}
