package 리트코드.LeetCode_189_RotateArray;

public class Solution_시간줄이기 {
    public void rotate(int[] nums, int k) {
        int[] temps = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            temps[(i + k) % nums.length] = nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = temps[i];
        }
    }
}
