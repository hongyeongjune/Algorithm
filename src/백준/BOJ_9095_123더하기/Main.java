package 백준.BOJ_9095_123더하기;

import java.io.*;

public class Main {

    public static int[] d;

    public static void main(String[] args) throws IOException {

        d = new int[10000];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        int[] result = new int[T];

        for(int i=0; i<T; i++) {

            int x = Integer.parseInt(br.readLine());

            result[i] = dp(x);
        }

        for(int i=0; i<T; i++) {
            bw.write(result[i] + "\n");
        }

        bw.flush();
        bw.close();
    }

    private static int dp(int x) {

        if(x == 0) return 0;
        if(x == 1) return 1;
        if(x == 2) return 2;
        if(x == 3) return 4;
        if(d[x] != 0) return d[x];
        return d[x] = dp(x-1) + dp(x-2) + dp(x-3);

    }
}
