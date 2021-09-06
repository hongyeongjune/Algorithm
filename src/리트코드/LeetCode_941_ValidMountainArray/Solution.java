package 리트코드.LeetCode_941_ValidMountainArray;

public class Solution {
    public boolean solution(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left + 1 < arr.length && arr[left] < arr[left + 1])
            left++;
        while (right > 0 && arr[right - 1] > arr[right])
            right--;
        return left > 0 && left == right && right < arr.length - 1;
    }
}
