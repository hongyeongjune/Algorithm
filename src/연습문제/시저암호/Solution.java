package 연습문제.시저암호;

public class Solution {
    public static String solution(String s, int n) {
        String answer = "";

        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                if (c + n <= 'Z') answer += (char) (c + n);
                else answer += (char) (c + n - 26);
            } else if (Character.isLowerCase(c)) {
                if (c + n <= 'z') answer += (char) (c + n);
                else answer += (char) (c + n - 26);
            } else answer += " ";
        }

        return answer;
    }

    public static void main(String[] args) {
        solution("AB", 1);
        solution("z", 1);
        solution("a B z", 4);
    }
}
