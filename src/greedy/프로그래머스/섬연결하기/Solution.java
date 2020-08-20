package greedy.프로그래머스.섬연결하기;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static int solution(int n, int[][] costs) {
        int answer = 0;
        int[] visited = new int[n];

        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        for(int i=0; i<costs.length; i++) {
            if(visited[costs[i][0]] == 1 && visited[costs[i][1]] == 1) {
                answer -= costs[i][2];
            }
            if(visited[costs[i][0]] == 0)
                visited[costs[i][0]] = 1;
            if(visited[costs[i][1]] == 0)
                visited[costs[i][1]] = 1;
            answer += costs[i][2];

            int sum = 0;

            for(int j=0; j<n; j++) {
                sum += visited[j];
            }
            if(sum == n) {
                break;
            }
        }

        return answer;
    }
}
