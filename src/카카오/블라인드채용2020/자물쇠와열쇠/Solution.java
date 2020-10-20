package 카카오.블라인드채용2020.자물쇠와열쇠;

public class Solution {
    public static boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        int[][] key90 = rotate(key);
        int[][] key180 = rotate(key90);
        int[][] key270 = rotate(key180);
        int[][] board = new int[lock.length * 3][lock.length * 3];

        int x = lock.length - key.length + 1;
        int y = lock.length * 2 - 1;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (i >= lock.length && i < lock.length * 2 && j >= lock.length && j < lock.length * 2) {
                    board[i][j] = lock[i - lock.length][j - lock.length];
                } else board[i][j] = -1;
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (i >= x && i <= y && j >= x && j <= y) {
                    if (move(i, j, board, key, lock)) return answer = true;
                    if (move(i, j, board, key90, lock)) return answer = true;
                    if (move(i, j, board, key180, lock)) return answer = true;
                    if (move(i, j, board, key270, lock)) return answer = true;
                }
            }
        }

        return answer;
    }

    private static boolean move(int x, int y, int[][] board, int[][] key, int[][] lock) {

        int[][] temp = new int[board.length][board.length];

        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp.length; j++) {
                temp[i][j] = board[i][j];
            }
        }

        int startX = x;
        int startY = y;
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                temp[startX][startY] += key[i][j];
                startY++;
            }
            startX++;
            startY = y;
        }

        return check(temp, lock);
    }

    private static boolean check(int[][] temp, int[][] lock) {

        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp.length; j++) {
                if (i >= lock.length && i < lock.length * 2 && j >= lock.length && j < lock.length * 2) {
                    if (temp[i][j] == 2 || temp[i][j] == 0)
                        return false;
                }
            }
        }
        return true;
    }

    private static int[][] rotate(int[][] key) {

        int[][] rotation = new int[key.length][key.length];

        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                rotation[i][j] = key[key.length - 1 - j][i];
            }
        }

        return rotation;
    }
}
