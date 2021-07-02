package 프로그래머스.Programmers_순위검색;

import java.util.*;

public class Solution_다시시도 {
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        Map<String, List<Integer>> map = new HashMap<>();

        for (String str : info) {
            dfs(str.split(" "), map, "", 0);
        }

        for (String key : map.keySet()) {
            Collections.sort(map.get(key));
            map.put(key, map.get(key));
        }

        for (int i = 0; i < query.length; i++) {
            String[] split1 = query[i].split(" and ");
            String[] split2 = split1[3].split(" ");
            String value = split1[0] + split1[1] + split1[2] + split2[0];

            for (String key : map.keySet()) {
                if (!value.equals(key)) continue;

                int index = lowerBound(map.get(key), Integer.parseInt(split2[1]));
                answer[i] = map.get(key).size() - index;
            }
        }

        return answer;
    }

    private int lowerBound(List<Integer> data, int target) {
        int left = 0;
        int right = data.size();

        while (left < right) {
            int mid = (left + right) / 2;

            if (data.get(mid) >= target) right = mid;
            else left = mid + 1;
        }

        return right;
    }

    private void dfs(String[] info, Map<String, List<Integer>> map, String answer, int index) {
        if (index == 4) {
            map.computeIfAbsent(answer, key -> new ArrayList<>()).add(Integer.parseInt(info[4]));
            return;
        }

        dfs(info, map, answer + "-", index + 1);
        dfs(info, map, answer + info[index], index + 1);
    }

    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};
        Solution_다시시도 solution_다시시도 = new Solution_다시시도();
        solution_다시시도.solution(info, query);
    }
}
