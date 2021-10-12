package 프로그래머스.Programmers_교점에별만들기;

import java.util.*;

public class Solution {

    public static int startX = Integer.MAX_VALUE;
    public static int endX = Integer.MIN_VALUE;
    public static int startY = Integer.MAX_VALUE;
    public static int endY = Integer.MIN_VALUE;

    public String[] solution(int[][] line) {
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < line.length - 1; i++) {
            for (int j = i + 1; j < line.length; j++) {
                long x1 = line[i][0];
                long y1 = line[i][1];
                long c1 = line[i][2];

                long x2 = line[j][0];
                long y2 = line[j][1];
                long c2 = line[j][2];

                long denominator = (x1 * y2) - (x2 * y1);
                if (denominator == 0) continue;

                long numerator1 = (y1 * c2) - (y2 * c1);
                long numerator2 = (x2 * c1) - (x1 * c2);
                if (numerator1 % denominator != 0 || numerator2 % denominator != 0) continue;

                int x = (int) (numerator1 / denominator);
                int y = (int) (numerator2 / denominator);

                List<Integer> temp = Arrays.asList(x, y);
                if (!set.contains(temp)) set.add(temp);

                startX = Math.min(startX, x);
                endX = Math.max(endX, x);
                startY = Math.min(startY, y);
                endY = Math.max(endY, y);
            }
        }

        List<String> board = new ArrayList<>();
        for (int i = startY; i <= endY; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = startX; j <= endX; j++) {
                sb.append(".");
            }
            board.add(sb.toString());
        }

        for (List<Integer> intersection : set) {
            StringBuilder sb = new StringBuilder(board.get(Math.abs(intersection.get(1) - endY)));
            sb.setCharAt(Math.abs(intersection.get(0) - startX), '*');
            board.set(Math.abs(intersection.get(1) - endY), sb.toString());
        }

        String[] answer = new String[board.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = board.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[][]{
                {2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}
        });
    }
}
