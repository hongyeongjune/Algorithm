package 리트코드.LeetCode_165_CompareVersionNumbers;

public class Solution {
    public int compareVersion(String version1, String version2) {

        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");

        int length = Math.min(split1.length, split2.length);

        for (int i = 0; i < length; i++) {
            int number1 = Integer.parseInt(split1[i]);
            int number2 = Integer.parseInt(split2[i]);

            if (number1 < number2) {
                return -1;
            } else if (number1 > number2) {
                return 1;
            }
        }

        if (split2.length > length) {
            for (int i = length; i < split2.length; i++) {
                if (Integer.parseInt(split2[i]) > 0) return -1;
            }
        } else if (split1.length > length) {
            for (int i = length; i < split1.length; i++) {
                if (Integer.parseInt(split1[i]) > 0) return 1;
            }
        }

        return 0;
    }
}
