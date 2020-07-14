package greedy.BackJoon.zeroCoin11047;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static int[] d;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int money = Integer.parseInt(st.nextToken());

        d = new int[x];

        for(int i=0; i<x; i++)
            d[i] = Integer.parseInt(br.readLine());

        bw.write(greedy(d, money) + "");
        bw.flush();
        bw.close();

    }

    private static int greedy(int[] x, int money) {

        int sum = 0;

        for(int i=x.length - 1; i>=0; i--) {

            if(money == 0)
                return sum;

            if(money/x[i] > 0) {
                sum += money/x[i];
                money %= x[i];
            }

        }

        return sum;
    }
}
