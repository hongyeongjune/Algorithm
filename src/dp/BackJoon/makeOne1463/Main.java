package dp.BackJoon.makeOne1463;

import java.io.*;

public class Main {

    static int count = 0;
    static int[] d;
    static int[] p;

    public static void main(String[] args) throws IOException {

        d = new int[1000001];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());

        p = new int[y+1];

        bw.write(dp_TopDown(x) + "\n");
        bw.write(dp_BottomUp(y)+ "\n");
        bw.flush();
        bw.close();

    }

    private static int dp_TopDown(int x) {

        if(x == 1) return 0;
        if(d[x] > 0) return d[x];

        d[x] = dp_TopDown(x - 1) + 1;

        if(x % 2 == 0) {
            d[x] = Math.min(d[x], dp_TopDown(x/2) + 1);
        }

        if(x % 3 == 0) {
            d[x] = Math.min(d[x], dp_TopDown(x/3) + 1);
        }

        return d[x];
    }

    private static int dp_BottomUp(int x) {

        p[0] = p[1] = 0;

        for(int i=2; i<=x; i++) {
            p[i] = p[i-1] + 1;
            if(i % 2 == 0)
                p[i] = Math.min(p[i], dp_BottomUp(i/2) + 1);
            if(i % 3 == 0)
                p[i] = Math.min(p[i], dp_BottomUp(i/3) + 1);
        }

        return p[x];
    }
}
