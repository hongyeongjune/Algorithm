package 알고리즘스터디._21년1월3주차.LeetCode_33_SearchInRotatedSortedArray;

public class Solution {
    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        int answer = -1;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                answer = mid;
            }

            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid])
                    right = mid - 1;
                else left = mid + 1;
            } else {
                if (target >= nums[mid] && target <= nums[right])
                    left = mid + 1;
                else right = mid - 1;
            }
        }

        return answer;
    }
}
