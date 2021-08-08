package 리트코드.LeetCode_1404_NumberOfStepsToReduceANumberInBinaryRepresentationToOne;

import java.math.BigInteger;

public class Solution {
    public int numSteps(String s) {
        int answer = 0;

        BigInteger bigInteger = new BigInteger(s, 2);
        while (bigInteger.intValue() != 1) {
            answer++;
            if (bigInteger.mod(BigInteger.valueOf(2)).intValue() == 0) {
                bigInteger = bigInteger.divide(BigInteger.valueOf(2));
            } else {
                bigInteger = bigInteger.add(BigInteger.valueOf(1));
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.numSteps("1111110011101010110011100100101110010100101110111010111110110010");
    }
}
