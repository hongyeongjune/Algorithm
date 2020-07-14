package dp.BackJoon.정수삼각형_1932;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static int[][] d;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int x = Integer.parseInt(br.readLine());

        d = new int[x][x];

        for(int i=0; i<x; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<=i; j++) {
                d[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bw.write(dp(d) + "");
        bw.flush();
        bw.close();

    }

    private static int dp(int[][] x) {

        int max = 0;

        for(int i=1; i<x.length; i++) {
            for(int j=0; j<=i; j++) {
                if(j==0) {
                    d[i][j] += d[i-1][j];
                }
                else if(i==j) {
                    d[i][j] += d[i-1][j-1];
                }
                else {
                    d[i][j] = Math.max(d[i][j] + d[i-1][j-1], d[i][j] + d[i-1][j]);
                }
            }
        }

        for(int i=0; i<x.length; i++) {

            if(max < d[x.length-1][i]) {
                max = d[x.length-1][i];
            }
        }

        return max;
    }

}
