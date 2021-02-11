package 프로그래머스.Programmers_단어변환;

public class Solution {
    public static int answer = 51;

    public int solution(String begin, String target, String[] words) {

        boolean[] visited = new boolean[words.length];
        dfs(begin, target, words, visited, 0);

        if(answer > 50) return 0;

        return answer;
    }

    public void dfs(String begin, String target, String[] words, boolean[] visited, int number) {


        if(begin.equals(target)) {
            if(answer > number) {
                answer = number;
            }
            return;
        }

        for(int i=0; i<words.length; i++) {

            int count = 0;

            for(int j=0; j<begin.length(); j++) {
                if(begin.charAt(j) != words[i].charAt(j)) count++;
            }

            if(count == 1 && !visited[i]) {
                visited[i] = true;
                dfs(words[i], target, words, visited, number+1);
                visited[i] = false;
            }
        }
    }
}
