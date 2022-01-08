package 프로그래머스.Programmers_단체사진찍기;

public class Solution_다시시도 {

    public static int answer;

    public int solution(int n, String[] data) {
        String[] friends = {"A", "C", "F", "J", "M", "N", "R", "T"};
        boolean[] visited = new boolean[friends.length];

        answer = 0;

        dfs(data, friends, visited, "");

        return answer;
    }

    private void dfs(String[] data, String[] friends, boolean[] visited, String friend) {

        if(friend.length() == friends.length) {
            if(isLine(data, friend)) answer++;
            return;
        }

        for(int i=0; i<friends.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(data, friends, visited, friend + friends[i]);
                visited[i] = false;
            }
        }
    }

    private boolean isLine(String[] data, String friend) {
        for(String d : data) {
            int diff = Math.abs(friend.indexOf(d.charAt(0)) - friend.indexOf(d.charAt(2)));
            int gap = Integer.parseInt(String.valueOf(d.charAt(4)));
            if(d.charAt(3) == '>' && !(diff - 1 > gap)) {
                return false;
            }
            else if(d.charAt(3) == '=' && !(diff - 1 == gap)) {
                return false;
            }
            else if(d.charAt(3) == '<' && !(diff - 1 < gap)) {
                return false;
            }
        }

        return true;
    }
}
