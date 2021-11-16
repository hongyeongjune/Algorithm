package 프로그래머스.Programmers_거리두기확인하기;

public class Solution_다시시도 {

    public static int[] dx1 = {-1, 0, 1, 0};
    public static int[] dy1 = {0, -1, 0, 1};
    public static int[] dx2 = {-2, 0, 2, 0};
    public static int[] dy2 = {0, -2, 0, 2};
    public static int[] dx3 = {-1, -1, 1, 1};
    public static int[] dy3 = {-1, 1, -1, 1};

    public static boolean flag = true;

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for (int i = 0; i < places.length; i++) {
            char[][] place = new char[5][5];
            for (int j = 0; j < place[i].length; j++) {
                place[j] = places[i][j].toCharArray();
            }

            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if (place[j][k] == 'P') {
                        check1(place, j, k);
                        check2(place, j, k);
                        check3(place, j, k);
                    }
                }
            }
            if (!flag) {
                answer[i] = 0;
            } else answer[i] = 1;
            flag = true;
        }

        return answer;
    }

    private void check1(char[][] place, int row, int col) {
        for (int i = 0; i < 4; i++) {
            int x = row + dx1[i];
            int y = col + dy1[i];

            if (x >= 0 && x < 5 && y >= 0 && y < 5 && place[x][y] == 'P') {
                flag = false;
                return;
            }
        }
    }

    private void check2(char[][] place, int row, int col) {
        for (int i = 0; i < 4; i++) {
            int x = row + dx2[i];
            int y = col + dy2[i];

            if (x >= 0 && x < 5 && y >= 0 && y < 5 && place[x][y] == 'P') {
                if (dx2[i] == 2 && place[row + 1][col] != 'X') {
                    flag = false;
                    return;
                } else if (dx2[i] == -2 && place[row - 1][col] != 'X') {
                    flag = false;
                    return;
                } else if (dy2[i] == 2 && place[row][col + 1] != 'X') {
                    flag = false;
                    return;
                } else if (dy2[i] == -2 && place[row][col - 1] != 'X') {
                    flag = false;
                    return;
                }
            }
        }
    }

    private void check3(char[][] place, int row, int col) {
        for (int i = 0; i < 4; i++) {
            int x = row + dx3[i];
            int y = col + dy3[i];

            if (x >= 0 && x < 5 && y >= 0 && y < 5 && place[x][y] == 'P') {
                if (dx3[i] == 1 && dy3[i] == 1 && (place[row + 1][col] != 'X' || place[row][col + 1] != 'X')) {
                    flag = false;
                    return;
                } else if (dx3[i] == 1 && dy3[i] == -1 && (place[row + 1][col] != 'X' || place[row][col - 1] != 'X')) {
                    flag = false;
                    return;
                } else if (dx3[i] == -1 && dy3[i] == 1 && (place[row - 1][col] != 'X' || place[row][col + 1] != 'X')) {
                    flag = false;
                    return;
                } else if (dx3[i] == -1 && dy3[i] == -1 && (place[row - 1][col] != 'X' || place[row][col - 1] != 'X')) {
                    flag = false;
                    return;
                }
            }
        }
    }
}
