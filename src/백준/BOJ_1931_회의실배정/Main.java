package 백준.BOJ_1931_회의실배정;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static int[][] g;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int x = Integer.parseInt(br.readLine());

        g = new int[x][2];

        for(int i=0; i<x; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<2; j++) {
                g[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bw.write(greedy(g) + "");
        bw.flush();
        bw.close();

    }

    private static int greedy(int[][] g) {

        Arrays.sort(g, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                if(o1[1] == o2[1])
                    return o1[0] - o2[0];

                return o1[1] - o2[1];
            }
        });

        int min = -1;
        int count = 0;

        for(int i=0; i<g.length; i++) {

            if(g[i][0] >= min) {
                min = g[i][1];
                count++;
            }

        }

        return count;

    }
}
