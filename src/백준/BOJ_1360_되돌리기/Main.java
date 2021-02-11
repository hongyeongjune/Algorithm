package 백준.BOJ_1360_되돌리기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] answer = new String[N + 1];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            String text = st.nextToken();
            int second = Integer.parseInt(st.nextToken());
        }


    }

    public static class Editor {
        String command;
        String text;
        int second;

        public Editor(String command, String text, int second) {
            this.command = command;
            this.text = text;
            this.second = second;
        }
    }
}
