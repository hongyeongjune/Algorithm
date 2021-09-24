package 프로그래머스.Programmers_상호평가;

public class Solution {
    public String solution(int[][] scores) {
        StringBuilder answer = new StringBuilder();
        for (int j = 0; j < scores[0].length; j++) {
            int self = scores[j][j];
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            int sum = 0;
            boolean flag = true;
            for (int i = 0; i < scores.length; i++) {
                min = Math.min(min, scores[i][j]);
                max = Math.max(max, scores[i][j]);

                if (i != j && self == scores[i][j]) flag = false;

                sum += scores[i][j];
            }

            if (flag && (max == self || min == self)) {
                sum -= self;
                answer.append(of(sum / (scores[0].length - 1)));
            } else answer.append(of(sum / scores[0].length));
        }

        return answer.toString();
    }

    public String of(double grade) {
        if (90 <= grade) return "A";
        else if (80 <= grade && grade < 90) return "B";
        else if (70 <= grade && grade < 80) return "C";
        else if (50 <= grade && grade < 70) return "D";
        else return "F";
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[][]{
                {50, 90}, {50, 87}
        });
    }
}
