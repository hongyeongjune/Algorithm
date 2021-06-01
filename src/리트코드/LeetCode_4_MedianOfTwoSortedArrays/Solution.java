package 리트코드.LeetCode_4_MedianOfTwoSortedArrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        List<Integer> nums = new ArrayList<>();
        for (int num : nums1) {
            nums.add(num);
        }

        for (int num : nums2) {
            nums.add(num);
        }

        Collections.sort(nums);

        if (nums.size() % 2 == 1) {
            return nums.get(nums.size() / 2);
        } else {
            return (nums.get(nums.size() / 2) + nums.get(nums.size() / 2 - 1)) * 1.0 / 2;
        }
    }
}
