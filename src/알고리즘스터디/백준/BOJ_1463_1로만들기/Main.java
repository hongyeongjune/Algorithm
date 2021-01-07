package 알고리즘스터디.백준.BOJ_1463_1로만들기;

import java.io.*;

public class Main {

    public static int[] d;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        d = new int[N + 1];

        System.out.println(dp_update(N));

    }

    public static int dp_update(int N) {
        d[0] = d[1] = 0;

        for (int i = 2; i <= N; i++) {
            d[i] = d[i - 1] + 1;
            if (i % 2 == 0) d[i] = Math.min(d[i], d[i / 2] + 1);
            if (i % 3 == 0) d[i] = Math.min(d[i], d[i / 3] + 1);
        }

        return d[N];
    }
}
