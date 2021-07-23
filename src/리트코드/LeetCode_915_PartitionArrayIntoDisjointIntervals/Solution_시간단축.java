package 리트코드.LeetCode_915_PartitionArrayIntoDisjointIntervals;

public class Solution_시간단축 {
    public int partitionDisjoint(int[] a) {
        int localMax = a[0], partitionIdx = 0, max = localMax;
        for (int i = 1; i < a.length; i++) {
            max = Math.max(max, a[i]);
            if (localMax > a[i]) {
                localMax = max;
                partitionIdx = i;
            }
        }
        return partitionIdx + 1;
    }

    public static void main(String[] args) {
        Solution_시간단축 solution시간단축 = new Solution_시간단축();
        solution시간단축.partitionDisjoint(new int[]{5, 0, 3, 8, 6});
        solution시간단축.partitionDisjoint(new int[]{1, 1, 1, 0, 6, 12});
    }
}
