package 리트코드.LeetCode_720_LongestWordInDictionary;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words);
        Set<String> set = new HashSet<>();

        String answer = "";

        for (String word : words) {
            if (word.length() == 1 || set.contains(word.substring(0, word.length() - 1))) {
                answer = answer.length() < word.length() ? word : answer;
                set.add(word);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.longestWord(new String[]{
                "a", "banana", "app", "appl", "ap", "apply", "apple"
        });
    }
}
