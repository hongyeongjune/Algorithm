package dp.BackJoon.distanceRGB1149;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static int[][] color;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int x = Integer.parseInt(br.readLine());

        color = new int[x+1][3];

        for(int i=1; i<=x; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++) {
                color[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bw.write(dp(x) + "");
        bw.flush();
        bw.close();
    }

    private static int dp(int x) {

       for(int i=2; i<=x; i++) {
           color[i][0] = Math.min(color[i][0] + color[i-1][1], color[i][0] + color[i-1][2]);
           color[i][1] = Math.min(color[i][1] + color[i-1][0], color[i][1] + color[i-1][2]);
           color[i][2] = Math.min(color[i][2] + color[i-1][0], color[i][2] + color[i-1][1]);
       }

       return Math.min(color[x][0], Math.min(color[x][1], color[x][2]));
    }

}
