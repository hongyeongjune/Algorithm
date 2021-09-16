package 리트코드.LeetCode_848_ShiftingLetters;

public class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        char[] arr = s.toCharArray();

        shifts[shifts.length - 1] %= 26;

        for (int i = shifts.length - 2; i >= 0; i--) {
            shifts[i] = (shifts[i] + shifts[i + 1]) % 26;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (char) (arr[i] + shifts[i] > 122 ? arr[i] + shifts[i] - 26 : arr[i] + shifts[i]);
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (char a : arr) stringBuilder.append(a);

        return stringBuilder.toString();
    }
}


//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        solution.shiftingLetters("abc", new int[]{3, 5, 9});
//    }