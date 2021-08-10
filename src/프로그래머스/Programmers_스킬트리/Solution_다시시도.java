package 프로그래머스.Programmers_스킬트리;

import java.util.ArrayList;
import java.util.List;

public class Solution_다시시도 {
    public int solution(String skill, String[] skill_trees) {

        int answer = 0;

        List<String> skillTrees = new ArrayList<>();

        for (String skill_tree : skill_trees) {
            String temp = "";
            for (int i = 0; i < skill_tree.length(); i++) {
                if (skill.indexOf(skill_tree.charAt(i)) != -1) {
                    temp += skill_tree.charAt(i);
                }
            }
            skillTrees.add(temp);
        }

        for (int i = 0; i < skillTrees.size(); i++) {
            int count = 0;
            for (int j = 0; j < skillTrees.get(i).length(); j++) {
                if (skill.charAt(j) == skillTrees.get(i).charAt(j)) {
                    count++;
                }
            }

            if (skillTrees.get(i).length() == count) answer++;
        }

        return answer;
    }
}
