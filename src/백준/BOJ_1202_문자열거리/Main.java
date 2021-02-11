package 백준.BOJ_1202_문자열거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String O = br.readLine();
        String N = br.readLine();
        int count = 0;
        boolean check = false;

        int[][] LCS = new int[O.length() + 1][N.length() + 1];
        int[][] COUNT = new int[O.length() + 1][N.length() + 1];

        for (int i = 1; i <= O.length(); i++) {
            LCS[i][0] = i;
        }
        for (int j = 1; j <= N.length(); j++) {
            LCS[0][j] = j;
        }

        for (int i = 1; i <= O.length(); i++) {
            for (int j = 1; j <= N.length(); j++) {
                if (O.charAt(i - 1) == N.charAt(j - 1)) {
                    LCS[i][j] = LCS[i - 1][j - 1];
                    if (check) {
                        count++;
                        check = false;
                    }
                } else {
                    LCS[i][j] = Math.min(LCS[i - 1][j], LCS[i][j - 1]) + 1;
                    check = true;
                }
            }
        }

        for (int i = 0; i < LCS.length; i++) {
            for (int j = 0; j < LCS[i].length; j++)
                System.out.print(LCS[i][j] + " ");
            System.out.println("");
        }
        System.out.println("");

    }
}


