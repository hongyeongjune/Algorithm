package 백준.BOJ_13275_가장긴팰린드롬부분문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();


        for (int i = S.length(); i > 0; i--) {

            for (int j = 0; j < S.length() - i; j++) {
                int left = j;
                int right = i - 1 + j;
            }
        }

    }
}
