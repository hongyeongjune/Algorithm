package 리트코드.LeetCode_334_IncreasingTripletSubsequence;

public class Solution {
    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num <= min) {
                min = num;
            } else if (num <= max) {
                max = num;
            } else return true;
        }
        return false;
    }
}
