package 리트코드.LeetCode_738_MonotoneIncreasingDigits;

class Solution {
    public int monotoneIncreasingDigits(int n) {
        char[] arr = String.valueOf(n).toCharArray();

        int memo = arr.length;

        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[i] < arr[i - 1]) {
                arr[i - 1]--;
                memo = i - 1;
            }
        }

        for (int i = memo + 1; i < arr.length; i++) {
            arr[i] = '9';
        }

        return Integer.parseInt(new String(arr));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.monotoneIncreasingDigits(1231));
    }
}