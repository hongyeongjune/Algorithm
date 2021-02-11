package 프로그래머스.Programmers_방문길이;

public class Solution {
    public static int solution(String dirs) {
        int answer = 0;
        boolean[][][][] check = new boolean[11][11][11][11];

        int x = 0, y = 0;

        for (Character dir : dirs.toCharArray()) {

            int a = x, b = y;

            switch (dir) {
                case 'U':
                    b++;
                    break;
                case 'D':
                    b--;
                    break;
                case 'L':
                    a--;
                    break;
                case 'R':
                    a++;
                    break;
            }

            if (Math.abs(a) > 5 || Math.abs(b) > 5) continue;

            if (!check[a + 5][b + 5][x + 5][y + 5]) {
                check[a + 5][b + 5][x + 5][y + 5] = check[x + 5][y + 5][a + 5][b + 5] = true;
            }

            x = a;
            y = b;

        }

        return answer;
    }
}