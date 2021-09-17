package 리트코드.LeetCode_179_LargestNumber;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public String largestNumber(int[] nums) {
        String[] strNums = new String[nums.length];

        for (int i = 0; i < strNums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                String first = o1 + o2;
                String second = o2 + o1;
                return second.compareTo(first);
            }
        };

        Arrays.sort(strNums, comparator);

        if (strNums[0].charAt(0) == '0') return "0";

        StringBuilder stringBuilder = new StringBuilder();
        for (String str : strNums) {
            stringBuilder.append(str);
        }

        return stringBuilder.toString();
    }
}
