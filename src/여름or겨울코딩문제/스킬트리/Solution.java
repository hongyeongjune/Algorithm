package 여름or겨울코딩문제.스킬트리;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        List<String> advance_skill = new ArrayList<>();

        for (String skill_tree : skill_trees) {
            String temp = "";
            for (int i = 0; i < skill_tree.length(); i++) {
                if (skill.indexOf(skill_tree.charAt(i)) != -1) {
                    temp += skill_tree.charAt(i);
                }
            }
            advance_skill.add(temp);
        }

        for (int i = 0; i < advance_skill.size(); i++) {
            int count = 0;
            for (int j = 0; j < advance_skill.get(i).length(); j++) {
                if (skill.charAt(j) == advance_skill.get(i).charAt(j)) {
                    count++;
                }
            }

            if (count == advance_skill.get(i).length()) answer++;
        }

        return answer;

    }
}
