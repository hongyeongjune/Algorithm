package 백준.BOJ_2579_계단오르기;

import java.io.*;

public class Main {

    public static int[] d;
    public static int[] steps;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int x = Integer.parseInt(br.readLine());

        steps = new int[x+1];
        d = new int[x+1];

        for(int i=1; i<=x; i++)
            steps[i] = Integer.parseInt(br.readLine());

        bw.write(dp(x) + "");
        bw.flush();
        bw.close();

    }

    private static int dp(int x) {

        if(d[x] != 0) return d[x];

        d[1] = steps[1];
        d[2] = steps[1] + steps[2];

        for(int i=3; i<=x; i++)
            d[i] = Math.max(d[i-2] + steps[i], d[i-3] + steps[i] + steps[i-1]);

        return d[x];
    }
}
