package 프로그래머스.Programmers_단체사진찍기;

public class Solution_다시풀기 {
    public static int answer;

    public int solution(int n, String[] data) {
        String[] friends = {"A", "C", "F", "J", "M", "N", "R", "T"};
        boolean[] visited = new boolean[friends.length];

        answer = 0;
        dfs(n, data, friends, visited, "");

        return answer;
    }

    private void dfs(int n, String[] data, String[] friends, boolean[] visited, String friend) {
        if (friend.length() == 8) {
            if (isLineUp(data, friend)) answer++;
            return;
        }

        for (int i = 0; i < friends.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(n, data, friends, visited, friend + friends[i]);
                visited[i] = false;
            }
        }
    }

    private boolean isLineUp(String[] data, String friend) {
        for (String d : data) {
            int interval = Math.abs(friend.indexOf(d.charAt(0)) - friend.indexOf(d.charAt(2)));
            int number = d.charAt(4) - '0';
            if (d.charAt(3) == '=' && !(interval == number + 1)) {
                return false;
            } else if (d.charAt(3) == '>' && !(interval > number + 1)) {
                return false;
            } else if (d.charAt(3) == '<' && !(interval < number + 1)) {
                return false;
            }
        }
        return true;
    }

}
