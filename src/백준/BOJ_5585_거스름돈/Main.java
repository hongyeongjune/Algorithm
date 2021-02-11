package 백준.BOJ_5585_거스름돈;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int x = Integer.parseInt(br.readLine());

        bw.write(greedy(x) + "");
        bw.flush();
        bw.close();
    }

    private static int greedy(int x) {

        int[] money = {500, 100, 50, 10, 5, 1};

        int sum = 0;
        x = 1000 - x;

        for(int i=0; i<money.length; i++) {

            if(x/money[i] > 0) {
                sum += (x/money[i]);
                x %= money[i];
            }

        }

        return sum;

    }
}
