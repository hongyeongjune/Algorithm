package 리트코드.LeetCode_838_PushDominoes;

public class Solution {
    public String pushDominoes(String dominoes) {
        int[] left = new int[dominoes.length()];
        int[] right = new int[dominoes.length()];

        for (int i = 0, R = -1; i < dominoes.length(); i++) {
            if (dominoes.charAt(i) == 'R') R = i;
            else if (dominoes.charAt(i) == 'L') R = -1;
            else {
                if (R != -1) right[i] = i - R;
            }
        }

        for (int i = dominoes.length() - 1, L = dominoes.length(); i >= 0; i--) {
            if (dominoes.charAt(i) == 'L') L = i;
            else if (dominoes.charAt(i) == 'R') L = dominoes.length();
            else {
                if (L != dominoes.length()) left[i] = L - i;
            }
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < dominoes.length(); i++) {
            char domino = dominoes.charAt(i);
            if (domino == 'L') answer.append('L');
            else if (domino == 'R') answer.append('R');
            else {
                if (left[i] != 0 && right[i] == 0) answer.append('L');
                else if (left[i] == 0 && right[i] != 0) answer.append('R');
                else if (left[i] > right[i]) answer.append('R');
                else if (left[i] < right[i]) answer.append('L');
                else answer.append('.');
            }
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.pushDominoes(".L.R...LR..L..");
    }
}
