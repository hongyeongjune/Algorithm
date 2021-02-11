package 백준.BOJ_2193_이친수;

import java.io.*;

public class Main {

    public static long[][] d;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        d = new long[91][2];

        int x = Integer.parseInt(br.readLine());

        bw.write(dp(x) + "");
        bw.flush();
        bw.close();
    }

    private static long dp(int x) {

        d[1][0] = 0L;
        d[1][1] = 1L;

        for(int i=2; i<=x; i++) {
            d[i][0] = d[i-1][0] + d[i-1][1];
            d[i][1] = d[i-1][0];
        }

        return d[x][0] + d[x][1];
    }

}
