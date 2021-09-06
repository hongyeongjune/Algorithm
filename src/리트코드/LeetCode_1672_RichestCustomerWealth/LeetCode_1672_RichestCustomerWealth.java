package 리트코드.LeetCode_1672_RichestCustomerWealth;

import java.util.Arrays;

public class LeetCode_1672_RichestCustomerWealth {
    // 주어진 2차원 배열에서 각 행의 합 중 가장 큰 값을 찾아라
    // ex) arr : [[1,2,3],[3,2,2]];
    // solution) answer : Math.max(1+2+3, 3+2+2) = 7;
    public int solution(int[][] arr) {
        int answer = Integer.MIN_VALUE;
        for (int[] a : arr) {
            answer = Math.max(answer, Arrays.stream(a).sum());
        }
        return answer;
    }
}
