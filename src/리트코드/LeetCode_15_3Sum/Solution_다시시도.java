package 리트코드.LeetCode_15_3Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_다시시도 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> answer = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    List<Integer> list = new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right]));
                    if (!answer.contains(list)) answer.add(list);
                    right--;
                    left++;
                } else if (sum > 0) {
                    right--;
                } else left++;
            }
        }
        return answer;
    }
}
