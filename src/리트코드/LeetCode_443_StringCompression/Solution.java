package 리트코드.LeetCode_443_StringCompression;

public class Solution {
    public int compress(char[] chars) {

        int answerIndex = 0;

        int index = 0;
        while (index < chars.length) {
            char current = chars[index];
            int count = 0;
            while (index < chars.length && current == chars[index]) {
                count++;
                index++;
            }

            chars[answerIndex++] = current;
            if (count != 1) {
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[answerIndex++] = c;
                }
            }
        }

        return answerIndex;
    }
}
