package 리트코드.LeetCode_983_MinimumCostForTickets;

import java.util.HashSet;
import java.util.Set;

public class Solution_시간단축 {
    public int mincostTickets(int[] days, int[] costs) {

        int[] memo = new int[366];

        int index = 0;

        for (int i = 1; i < memo.length; i++) {

            if (index == days.length) break;

            // 현재 날짜가 다음 여행날짜와 일치하지 않는다면 이전 값을 가지고 간다
            if (i != days[index]) memo[i] = memo[i - 1];

            else {
                // 하루 비용
                int oneDay = memo[i - 1] + costs[0];
                // 7일 비용
                int sevenDay = memo[Math.max(i - 7, 0)] + costs[1];
                // 30일 비용
                int thirtyDay = memo[Math.max(i - 30, 0)] + costs[2];
                // 현재 최솟값 기록
                memo[i] = Math.min(oneDay, Math.min(sevenDay, thirtyDay));

                // index 증가
                index++;
            }
        }

        return memo[days[index - 1]];
    }
}
