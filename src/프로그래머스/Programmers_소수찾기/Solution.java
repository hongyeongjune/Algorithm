package 프로그래머스.Programmers_소수찾기;

public class Solution {
    public static int solution(int n) {
        int answer = 0;
        boolean[] primes = new boolean[n + 1];

        for (int i = 2; i < primes.length; i++) {
            primes[i] = true;
        }

        int root = (int) Math.sqrt(n);

        for (int i = 2; i <= root; i++) {
            if (primes[i]) {
                for (int j = i; i * j <= n; j++) primes[i * j] = false;
            }
        }

        for (int i = 2; i <= n; i++) {
            if (primes[i]) System.out.print(i + " ");
        }

        return answer;
    }

    public static void main(String[] args) {
        solution(20);
    }

}
