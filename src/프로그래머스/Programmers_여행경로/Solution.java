package 프로그래머스.Programmers_여행경로;

import java.util.*;

public class Solution {
    public class AirPort {
        private String arrive;
        private boolean visited;

        public AirPort(String arrive) {
            this.arrive = arrive;
            this.visited = false;
        }
    }

    public String[] solution(String[][] tickets) {
        String[] answer = new String[tickets.length + 1];
        HashMap<String, List<AirPort>> hashMap = new HashMap<>();
        for (String[] ticket : tickets) {
            if (hashMap.get(ticket[0]) == null) {
                List<AirPort> airPorts = new ArrayList<>();
                airPorts.add(new AirPort(ticket[1]));
                hashMap.put(ticket[0], airPorts);
            } else {
                List<AirPort> airPorts = hashMap.get(ticket[0]);
                airPorts.add(new AirPort(ticket[1]));
                Collections.sort(airPorts, new Comparator<AirPort>() {
                    @Override
                    public int compare(AirPort o1, AirPort o2) {
                        return o1.arrive.compareTo(o2.arrive);
                    }
                });
                hashMap.put(ticket[0], airPorts);
            }
        }
        answer[0] = "ICN";
        for (int i = 1; i < answer.length; i++) {

            for (int j = 0; j < hashMap.get(answer[i - 1]).size(); j++) {
                if (!hashMap.get(answer[i - 1]).get(j).visited) {
                    hashMap.get(answer[i - 1]).get(j).visited = true;
                    answer[i] = hashMap.get(answer[i - 1]).get(j).arrive;
                    break;
                }
            }

        }
        return answer;
    }
}
