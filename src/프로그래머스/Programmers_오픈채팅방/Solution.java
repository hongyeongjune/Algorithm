package 프로그래머스.Programmers_오픈채팅방;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public String[] solution(String[] record) {

        Map<String, String> map = new HashMap<>();

        for (String r : record) {
            String[] split = r.split(" ");
            if (split.length == 3) {
                map.put(split[1], split[2]);
            }
        }

        List<String> answer = new ArrayList<>();
        for (String r : record) {
            String[] split = r.split(" ");
            if (split[0].equals("Enter")) {
                answer.add(map.get(split[1]) + "님이 들어왔습니다.");
            } else if (split[0].equals("Leave")) {
                answer.add(map.get(split[1]) + "님이 나갔습니다.");
            }
        }

        return answer.toArray(new String[answer.size()]);
    }
}
