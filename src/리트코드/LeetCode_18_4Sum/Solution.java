package 리트코드.LeetCode_18_4Sum;


import java.util.*;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        Set<List<Integer>> answer = new HashSet<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {

                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {

                    int sum = nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        List<Integer> temp = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        if (!answer.contains(temp)) answer.add(temp);

                        left++;
                        right--;
                    } else if (sum > target) right--;
                    else left++;
                }

            }
        }

        return new ArrayList<>(answer);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.fourSum(new int[]{-4, -3, -2, -1, 0, 0, 1, 2, 3, 4}, 0);
    }
}
