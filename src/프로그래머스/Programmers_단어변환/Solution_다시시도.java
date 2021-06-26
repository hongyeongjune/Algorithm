package 프로그래머스.Programmers_단어변환;

public class Solution_다시시도 {
    private static int answer = 51;

    public int solution(String begin, String target, String[] words) {

        boolean[] visited = new boolean[words.length];

        dfs(begin, target, words, visited, 0);

        if (answer > 50) return 0;

        return answer;
    }

    private void dfs(String begin, String target, String[] words, boolean[] visited, int sum) {

        if (begin.equals(target)) {
            answer = Math.min(answer, sum);
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (compareWords(begin, words[i]) == 1 && !visited[i]) {
                visited[i] = true;
                dfs(words[i], target, words, visited, sum + 1);
                visited[i] = false;
            }
        }
    }

    private int compareWords(String begin, String word) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (begin.charAt(i) != word.charAt(i))
                count++;
        }

        return count;
    }
}
