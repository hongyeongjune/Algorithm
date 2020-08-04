import java.io.*;

public class Main {

    private static int[] d;
    private static int[] stair;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int x = Integer.parseInt(br.readLine());

        d = new int[x+1];
        stair = new int[x+1];

        for(int i=1; i<=x; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }

        bw.write(dp(x) + "");
        bw.flush();
        bw.close();

    }

    private static int dp(int x) {

        if(x == 1) return stair[1];
        if(d[x] != 0) return d[x];

        d[1] = stair[1];
        d[2] = stair[1] + stair[2];

        for(int i=3; i<=x; i++) {
            d[i] = Math.max(d[i-3] + stair[i-1] + stair[i], d[i-2] + stair[i]);
        }

        return d[x];


    }

}
