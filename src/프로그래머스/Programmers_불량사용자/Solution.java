package 프로그래머스.Programmers_불량사용자;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class Solution {
    public static Set<Set<String>> answer;
    public static List<List<String>> bannedUserList;

    public int solution(String[] user_id, String[] banned_id) {

        answer = new HashSet<>();
        bannedUserList = new ArrayList<>();

        for (String id : banned_id) {
            bannedUserList.add(isBanned(id, user_id));
        }

        Set<String> set = new HashSet<>();
        dfs(set, 0);
        return answer.size();
    }

    private void dfs(Set<String> set, int depth) {
        if (depth == bannedUserList.size()) {
            answer.add(new HashSet<>(set));
            return;
        }

        for (String id : bannedUserList.get(depth)) {
            if (!set.contains(id)) {
                set.add(id);
                dfs(set, depth + 1);
                set.remove(id);
            }
        }
    }

    private List<String> isBanned(String banned_id, String[] user_id) {
        List<String> matches = new ArrayList<>();
        for (String id : user_id) {
            if (Pattern.matches(banned_id.replace('*', '.'), id))
                matches.add(id);
        }
        return matches;
    }
}
