package 백준.BOJ_1541_잃어버린괄호;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String formula = br.readLine();
        String[] calculate = formula.split("\\-");

        bw.write(greedy(calculate) + "");
        bw.flush();
        bw.close();
    }

    private static int greedy(String[] calculate) {

        int first = 0;
        int sum = 0;
        String[] temp1 = calculate[0].split("\\+");
        for(String t : temp1) {
            first += Integer.parseInt(t);
        }

        for(int i=1; i<calculate.length; i++) {
            String[] temp2 = calculate[i].split("\\+");
            for(String t : temp2) {
                sum += Integer.parseInt(t);
            }
        }

        return first - sum;
    }
}
