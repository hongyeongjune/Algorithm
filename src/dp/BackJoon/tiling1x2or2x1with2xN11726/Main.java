package dp.BackJoon.tiling1x2or2x1with2xN11726;

import java.io.*;

public class Main {

    public static int[] d;

    public static void main(String[] args) throws IOException {

        d = new int[1001];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int x = Integer.parseInt(br.readLine());

        bw.write(dp(x) + "");
        bw.flush();
        bw.close();

    }

    private static int dp(int x) {

        if(x==1) return 1;
        if(x==2) return 2;
        if(d[x] != 0) return d[x];

        return d[x] = (dp(x-1) + dp(x-2)) % 10007;
    }

}
