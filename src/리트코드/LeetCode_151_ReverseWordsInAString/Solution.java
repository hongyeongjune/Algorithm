package 리트코드.LeetCode_151_ReverseWordsInAString;

public class Solution {
    public String reverseWords(String s) {
        String trim = s.trim();
        String[] split = trim.split("\\s+");
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = split.length - 1; i > 0; i--) {
            stringBuilder.append(split[i] + " ");
        }

        stringBuilder.append(split[0]);

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.reverseWords("hello world");
    }
}
