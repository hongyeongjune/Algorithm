package dp.tiling2xNwith1x1;

import java.io.*;

public class Main {

    private static int[][] d;
    private static int[] p;

    public static void main(String[] args) throws IOException {

        d = new int[1000001][2];
        p = new int[1000001];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        String oneStr = br.readLine();
        int x = Integer.parseInt(str);
        int y = Integer.parseInt(oneStr);

        bw.write(oneDemension(x) + "\n");
        bw.write(dp(y) + "\n");
        bw.flush();
        bw.close();

    }

    private static int oneDemension(int x) {

        if(x == 0) return 1;
        if(x == 1) return 2;
        if(x == 2) return 7;
        if(p[x] != 0) return p[x];

        int result = 3 * oneDemension(x-2) + 2 * oneDemension(x-1);

        for(int i=3; i<=x; i++) {
            result += (2 * oneDemension(x-i)) % 1000000007;
        }

        return p[x] = result % 1000000007;
    }

    private static int dp(int x) {

        // 0 2 7
        //     1
        d[0][0] = 0;
        d[1][0] = 2;
        d[2][0] = 7;
        d[2][1] = 1;

        for(int i=3; i<=x; i++) {
            d[i][1] = (d[i-3][0] + d[i-1][1]) % 1000000007;
            d[i][0] = (3 * d[i-2][0] + 2 * d[i-1][0] + 2 * d[i][1]) % 1000000007;
        }

        return d[x][0];
    }
}
