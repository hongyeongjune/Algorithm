package 백준.BOJ_10610_30;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String x = br.readLine();

        bw.write(greedy(x));
        bw.flush();
        bw.close();
    }

    private static String greedy(String x) {

        Integer[] g = new Integer[x.length()];

        int sum = 0;

        for(int i=0; i<x.length(); i++) {
            g[i] = Integer.parseInt(String.valueOf(x.charAt(i)));
            sum += g[i];
        }

        Arrays.sort(g, Collections.reverseOrder());

        if(g[x.length()-1] != 0 || sum % 3 != 0) {
            return "-1";
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<x.length(); i++) {
            sb.append(g[i]);
        }

        return sb.toString();

    }

}
