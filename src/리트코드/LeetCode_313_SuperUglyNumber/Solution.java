package 리트코드.LeetCode_313_SuperUglyNumber;

public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] answer = new int[n];
        answer[0] = 1;

        int[] index = new int[primes.length];

        for (int i = 1; i < n; i++) {
            answer[i] = Integer.MAX_VALUE;

            for (int j = 0; j < primes.length; j++) {
                answer[i] = Math.min(answer[i], primes[j] * answer[index[j]]);
            }

            for (int j = 0; j < index.length; j++) {
                if (answer[i] == primes[j] * answer[index[j]])
                    index[j]++;
            }
        }

        return answer[n - 1];
    }
}
