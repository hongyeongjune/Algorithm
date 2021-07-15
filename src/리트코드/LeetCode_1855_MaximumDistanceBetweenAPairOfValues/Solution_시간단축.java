package 리트코드.LeetCode_1855_MaximumDistanceBetweenAPairOfValues;

public class Solution_시간단축 {
    public int maxDistance(int[] nums1, int[] nums2) {
        int answer = 0;
        int j = 0;
        for (int i = 0; i < nums1.length; i++) {
            while (j < nums2.length && nums1[i] <= nums2[j])
                j++;

            answer = Math.max(answer, j - 1 - i);
        }

        return answer;
    }
}
