package 리트코드.LeetCode_1300_SumOfMutatedArrayClosestToTarget;

public class Solution_시간단축 {
    public int findBestValue(int[] arr, int target) {
        int left = 1;
        int right = 0;
        for (int a : arr) {
            right = Math.max(right, a);
        }

        while (left < right) {
            int mid = (left + right) / 2;
            int difference = getDifference(arr, target, mid);
            if (difference > 0) {
                left = mid + 1;
            } else right = mid;
        }

        if (Math.abs(getDifference(arr, target, left - 1)) <= Math.abs(getDifference(arr, target, left))) {
            return left - 1;
        } else return left;
    }

    private int getDifference(int[] arr, int target, int value) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > value)
                sum += value;
            else sum += arr[i];
        }

        return target - sum;
    }
}
