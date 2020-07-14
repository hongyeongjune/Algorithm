package greedy.BackJoon.ATM11399;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static int[] d;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int x = Integer.parseInt(br.readLine());

        d = new int[x];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<x; i++) {
            d[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(greedy(d) + "");
        bw.flush();
        bw.close();

    }

    private static int greedy(int[] x) {

        int sum = 0;
        int temp = 0;

        for(int i=0; i<x.length; i++) {
            for(int j=i+1; j<x.length; j++) {
                if(d[i] >= d[j]) {
                    temp = d[i];
                    d[i] = d[j];
                    d[j] = temp;
                }
            }
        }

        for(int i=0; i<x.length; i++) {
            for(int j=0; j<=i; j++)
                sum += x[j];
        }

        return sum;

    }

}
