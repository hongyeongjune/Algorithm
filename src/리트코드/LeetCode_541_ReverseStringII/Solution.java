package 리트코드.LeetCode_541_ReverseStringII;

public class Solution {
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        int i = 0;
        while (i < arr.length) {
            int j = Math.min(i + k - 1, arr.length - 1);
            swap(arr, i, j);
            i += (2 * k);
        }

        return String.valueOf(arr);
    }

    private void swap(char[] arr, int i, int j) {
        while (i < j) {
            char temp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = temp;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.reverseStr("hyzqyljrnigxvdtneasepfahmtyhlohwxmkqcdfehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjqlimjkfnqcqnajmebeddqsgl", 39);
    }
}
