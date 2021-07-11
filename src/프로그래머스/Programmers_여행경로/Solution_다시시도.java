package 프로그래머스.Programmers_여행경로;

import java.util.*;

public class Solution_다시시도 {
    public String[] solution(String[][] tickets) {
        Map<String, List<Airport>> map = new HashMap<>();

        for (String[] ticket : tickets) {
            map.computeIfAbsent(ticket[0], key -> new ArrayList<>()).add(new Airport(ticket[1], false));
            map.computeIfAbsent(ticket[0], key -> new ArrayList<>()).sort(Comparator.comparing(Airport::getAirport));
        }

        String[] answer = new String[tickets.length + 1];
        answer[0] = "ICN";

        for (int i = 1; i < answer.length; i++) {
            for (int j = 0; j < map.get(answer[i - 1]).size(); j++) {
                if (!map.get(answer[i - 1]).get(j).visited) {
                    map.get(answer[i - 1]).get(j).visited = true;
                    answer[i] = map.get(answer[i - 1]).get(j).airport;
                    break;
                }
            }
        }

        return answer;
    }

    public class Airport {
        String airport;
        boolean visited;

        public String getAirport() {
            return airport;
        }

        public Airport(String airport, boolean visited) {
            this.airport = airport;
            this.visited = visited;
        }
    }

    public static void main(String[] args) {
        Solution_다시시도 solution = new Solution_다시시도();
        solution.solution(new String[][]{
                {"ICN", "SFO"},
                {"ICN", "ATL"},
                {"SFO", "ATL"},
                {"ATL", "ICN"},
                {"ATL", "SFO"}
        });
    }
}
