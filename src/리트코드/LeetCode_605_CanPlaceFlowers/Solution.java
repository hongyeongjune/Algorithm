package 리트코드.LeetCode_605_CanPlaceFlowers;

public class Solution {
    public boolean canPlaceFlowers(int[] nums, int n) {
        if (nums.length == 1) {
            if (nums[0] == 1 && n == 0) return true;
            else if (nums[0] == 1 && n == 1) return false;
            else if (nums[0] == 0) return true;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 && nums[i] == 0 && nums[i + 1] == 0) {
                nums[i] = 1;
                n--;
            } else if (i == nums.length - 1 && nums[i] == 0 && nums[i - 1] == 0) {
                nums[i] = 1;
                n--;
            } else if (i != 0 && i != nums.length - 1 && nums[i] == 0 && (nums[i - 1] == 0 && nums[i + 1] == 0)) {
                nums[i] = 1;
                n--;
            }
        }

        return n <= 0;
    }
}
