package 리트코드.LeetCode_1281_SubtractTheProductAndSumOfDigitsOfAnInteger;

public class LeetCode_1281_SubtractTheProductAndSumOfDigitsOfAnInteger {
    // 숫자가 주어질 때 각 자리수의 곱과 합의 차이를 구하라
    // ex) n : 1234
    // solution) answer : (1*2*3*4) - (1+2+3+4) = 14
    public int solution(int n) {
        int multiply = 1;
        int sum = 0;
        while (n > 0) {
            int mod = n % 10;
            sum += mod;
            multiply *= mod;
            n /= 10;
        }
        return multiply - sum;
    }
}
