package 리트코드.LeetCode_151_ReverseWordsInAString;

public class Solution_시간단축 {
    public String reverseWords(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        int index = s.length() - 1;

        while (index >= 0) {
            if (s.charAt(index) == ' ') {
                index--;
            } else {
                int temp = index;
                while (index >= 0 && s.charAt(index) != ' ') {
                    index--;
                }

                if (stringBuilder.length() > 0) {
                    stringBuilder.append(" ");
                }

                for (int i = index + 1; i <= temp; i++) {
                    stringBuilder.append(s.charAt(i));
                }
            }
        }

        return stringBuilder.toString();
    }
}
