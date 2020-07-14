package dp.tiling2xN;

import java.io.*;

public class Main {

    private static int[] d;
    public static void main(String[] args) throws IOException {
        d = new int[1001];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int x = Integer.parseInt(str);

        bw.write(dp(x)+"");
        bw.flush();
        bw.close();
    }

    static int dp(int x) {
        if(x==1) return 1;
        if(x==2) return 2;
        if(d[x] != 0) return d[x];
        return d[x] = (dp(x-1) + dp(x-2)) % 10007;
    }
}
