package 백준.BOJ_1062_가르침;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int ASCII = 97;
    public static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String[] words = new String[N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            words[i] = str.substring(4, str.length() - 4);
        }

        if (K < 5) {
            System.out.println(0);
            return;
        } else if (K == 26) {
            System.out.println(N);
            return;
        }

        boolean[] visited = new boolean[26];
        visited['a' - ASCII] = true;
        visited['n' - ASCII] = true;
        visited['t' - ASCII] = true;
        visited['i' - ASCII] = true;
        visited['c' - ASCII] = true;

        dfs(words, visited, N, K - 5, 0, 0);
        System.out.println(answer);
    }

    private static void dfs(String[] words, boolean[] visited, int N, int K, int count, int index) {

        if (count == K) {
            int max = 0;
            for (int i = 0; i < N; i++) {
                boolean isRead = true;
                for (int j = 0; j < words[i].length(); j++) {
                    if (!visited[words[i].charAt(j) - ASCII]) {
                        isRead = false;
                        break;
                    }
                }
                if (isRead) max++;
            }
            answer = Math.max(answer, max);
            return;
        }

        for (int i = index; i < 26; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(words, visited, N, K, count + 1, i);
                visited[i] = false;
            }
        }
    }
}
