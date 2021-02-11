package 백준.BOJ_1003_피보나치;

import java.io.*;

public class Main {

    public static int[] d;
    public static int[] p;

    public static void main(String[] args) throws IOException {

        d = new int[10000];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        int[] result = new int[T];

        for(int i=0; i<T; i++) {
            int x = Integer.parseInt(br.readLine());

            if(x == 0) bw.write("1 0\n");
            else bw.write(dp(x-1) + " " + dp(x) + "\n");
        }

        bw.flush();
        bw.close();

    }

    private static int dp(int x) {

        if(x == 0) return 0;

        if(x == 1) return 1;
        if(d[x] != 0) return d[x];

        return d[x] = dp(x-1) + dp(x-2);
    }

}
