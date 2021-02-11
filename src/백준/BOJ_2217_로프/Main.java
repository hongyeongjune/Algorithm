package 백준.BOJ_2217_로프;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int x = Integer.parseInt(br.readLine());

        Integer[] g = new Integer[x];

        for(int i=0; i<x; i++) {
            g[i] = Integer.parseInt(br.readLine());
        }

        bw.write(greedy(g, x) + "");
        bw.flush();
        bw.close();

    }

    private static int greedy(Integer[] g, int x) {

        Arrays.sort(g, Collections.reverseOrder());

        int max = g[0];

        for(int i=1; i<g.length; i++) {
            if(max < g[i] * (i+1))
                max = g[i] * (i+1);
        }

        return max;
    }
}
