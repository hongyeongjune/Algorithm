package 리트코드.LeetCode_845_LongestMountainInArray;

public class Solution {
    public int longestMountain(int[] arr) {
        int left = 0;
        int right;
        int answer = 0;

        while (left < arr.length - 2) {

            while (left < arr.length - 1 && arr[left] >= arr[left + 1]) {
                left++;
            }

            right = left + 1;

            while (right < arr.length - 1 && arr[right] < arr[right + 1]) {
                right++;
            }

            while (right < arr.length - 1 && arr[right] > arr[right + 1]) {
                right++;
                answer = Math.max(answer, right - left + 1);
            }
            left = right;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.longestMountain(new int[]{0, 1, 2, 3, 4, 5, 4, 3, 2, 1, 0});
    }
}
