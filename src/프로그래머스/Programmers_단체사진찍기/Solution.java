package 프로그래머스.Programmers_단체사진찍기;

public class Solution {
    public static int answer;

    public int solution(int n, String[] data) {
        boolean[] visited = new boolean[8];
        String[] friends = {"A", "C", "F", "J", "M", "N", "R", "T"};

        answer = 0;
        dfs(visited, friends, data, "");

        return answer;
    }

    private void dfs(boolean[] visited, String[] friends, String[] data, String friend) {
        if (friend.length() == 8) {
            if (check(friend, data)) answer++;
            return;
        }
        for (int i = 0; i < friends.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(visited, friends, data, friend + friends[i]);
                visited[i] = false;
            }
        }
    }

    private boolean check(String friend, String[] data) {
        for (String d : data) {
            int friends = friend.indexOf(d.charAt(0));
            int opponent = friend.indexOf(d.charAt(2));
            char operation = d.charAt(3);
            int interval = d.charAt(4) - '0';

            if (operation == '=') {
                if (!(Math.abs(friends - opponent) == interval + 1)) return false;
            } else if (operation == '>') {
                if (!(Math.abs(friends - opponent) > interval + 1)) return false;
            } else if (operation == '<') {
                if (!(Math.abs(friends - opponent) < interval + 1)) return false;
            }
        }
        return true;
    }
}
