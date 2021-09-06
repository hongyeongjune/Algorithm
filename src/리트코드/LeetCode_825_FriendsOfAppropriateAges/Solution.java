package 리트코드.LeetCode_825_FriendsOfAppropriateAges;

import java.util.*;

public class Solution {

    public int numFriendRequests(int[] ages) {

        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int age : ages) {
            map.merge(age, 1, Integer::sum);
        }

        for (int y : map.keySet()) {
            for (int x : map.keySet()) {
                if (isSend(x, y)) {
                    answer += (map.get(y) * (map.get(x) - (x == y ? 1 : 0)));
                }
            }
        }

        return answer;
    }

    private boolean isSend(double x, double y) {
        return (y <= 0.5 * x + 7) || (y > 100 && x < 100) || (y > x) ? false : true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.numFriendRequests(new int[]{16, 16});
    }
}
