package 프로그래머스.Programmers_거리두기확인하기;

public class Solution {

    public static int[] dx1 = {-1, 1, 0, 0};
    public static int[] dy1 = {0, 0, -1, 1};

    public static int[] dx2 = {-1, -1, 1, 1};
    public static int[] dy2 = {-1, 1, -1, 1};

    public static int[] dx3 = {-2, 2, 0, 0};
    public static int[] dy3 = {0, 0, -2, 2};

    public boolean flag = true;

    public int[] solution(String[][] places) {

        int[] answer = new int[5];

        for (int k = 0; k < places.length; k++) {
            char[][] place = new char[5][5];
            for (int i = 0; i < places[k].length; i++) {
                place[i] = places[k][i].toCharArray();
            }

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (place[i][j] == 'P') {
                        aroundCheck(i, j, place);
                        diagonalCheck(i, j, place);
                        twiceAroundCheck(i, j, place);
                    }
                }
            }

            if (flag) answer[k] = 1;
            else answer[k] = 0;

            flag = true;
        }

        return answer;
    }

    private void aroundCheck(int row, int col, char[][] place) {
        for (int i = 0; i < 4; i++) {
            int x = row + dx1[i];
            int y = col + dy1[i];

            if (x < 0 || y < 0 || x >= 5 || y >= 5) continue;
            if (place[x][y] == 'P') flag = false;
        }
    }

    private void diagonalCheck(int row, int col, char[][] place) {
        for (int i = 0; i < 4; i++) {
            int x = row + dx2[i];
            int y = col + dy2[i];

            if (x < 0 || y < 0 || x >= 5 || y >= 5) continue;
            if (place[x][y] == 'P') {
                if (dx2[i] == -1 && dy2[i] == -1) {
                    if (place[row - 1][col] != 'X' || place[row][col - 1] != 'X') flag = false;
                } else if (dx2[i] == 1 && dy2[i] == -1) {
                    if (place[row + 1][col] != 'X' || place[row][col - 1] != 'X') flag = false;
                } else if (dx2[i] == 1 && dy2[i] == 1) {
                    if (place[row + 1][col] != 'X' || place[row][col + 1] != 'X') flag = false;
                } else if (dx2[i] == -1 && dy2[i] == -1) {
                    if (place[row - 1][col] != 'X' || place[row][col + 1] != 'X') flag = false;
                }
            }
        }
    }

    private void twiceAroundCheck(int row, int col, char[][] place) {
        for (int i = 0; i < 4; i++) {
            int x = row + dx3[i];
            int y = col + dy3[i];

            if (x < 0 || y < 0 || x >= 5 || y >= 5) continue;
            if (place[x][y] == 'P') {
                if (dx3[i] == -2) {
                    if (place[row - 1][col] != 'X') flag = false;
                } else if (dx3[i] == 2) {
                    if (place[row + 1][col] != 'X') flag = false;
                } else if (dy3[i] == -2) {
                    if (place[row][col - 1] != 'X') flag = false;
                } else if (dy3[i] == 2) {
                    if (place[row][col + 1] != 'X') flag = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new String[][]{
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        });
    }
}
