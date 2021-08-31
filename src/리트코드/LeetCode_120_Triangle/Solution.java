package 리트코드.LeetCode_120_Triangle;

import java.util.Arrays;
import java.util.List;

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {

        int[][] arr = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];

        for (int i = 0; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                arr[i][j] = triangle.get(i).get(j);
            }
        }

        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (j == 0) arr[i][j] += arr[i - 1][j];
                else if (j == triangle.get(i).size() - 1) arr[i][j] += arr[i - 1][j - 1];
                else {
                    arr[i][j] += Math.min(arr[i - 1][j - 1], arr[i - 1][j]);
                }
            }
        }

        return Arrays.stream(arr[arr.length - 1]).min().getAsInt();
    }
}
