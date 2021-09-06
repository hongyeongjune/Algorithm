package 리트코드.LeetCode_7_ReverseInteger;

public class LeetCode_7_ReverseInteger {
    // 주어진 정수를 뒤집어서 출력한다.
    // 단, 주어진 정수를 뒤집었을 때 32비트 정수의 범위인 [-2^31, 2^31-1] 이 아니라면 0을 return 한다.
    // ex) x : 123
    // solution) answer : 321
    public int solution(int x) {
        long answer = 0;
        while (x != 0) {
            long mod = x % 10;
            answer *= 10;
            answer += mod;
            if (answer > Integer.MAX_VALUE || answer < Integer.MIN_VALUE) return 0;
            x /= 10;
        }
        return (int) answer;
    }
}
