package 크루스칼알고리즘.프로그래머스.섬연결하기;

import java.util.ArrayList;
import java.util.Iterator;

public class Others {
    public int solution(int n, int[][] costs) {
        int[][] island = new int[n][n];

        for (int[] cost : costs) {
            if (cost.length > 0) {
                island[cost[0]][cost[1]] = cost[2];
                island[cost[1]][cost[0]] = cost[2];
            }
        }

        ArrayList<Integer> connected = new ArrayList<>();
        Iterator<Integer> it;
        connected.add(0);

        int sum = 0;
        while (connected.size() < n) {
            long min = -1;
            int minI = -1, minJ = -1;

            it = connected.iterator();
            while (it.hasNext()) {
                int start = it.next();
                for (int end = 0; end < n; end++) {
                    if (!connected.contains(end)) {
                        if (island[start][end] > 0) {
                            if (island[start][end] < min || min == -1) {
                                min = island[start][end];
                                minI = start;
                                minJ = end;
                            }
                        }
                    }
                }
            }
            sum += min;
            connected.add(minJ);
            island[minI][minJ] = 0;
            island[minJ][minI] = 0;
        }
        return sum;
    }
}
