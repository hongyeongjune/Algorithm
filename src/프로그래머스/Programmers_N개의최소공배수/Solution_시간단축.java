package 프로그래머스.Programmers_N개의최소공배수;

public class Solution_시간단축 {
    public int solution(int[] arr) {
        long answer = arr[0];
        for (int i = 1; i < arr.length; i++) {
            long p = Math.max(answer, arr[i]);
            long q = Math.min(answer, arr[i]);
            answer = (p * q) / gcd(p, q);
        }
        return (int) answer;
    }

    public long gcd(long p, long q) {
        if (q == 0) return p;
        else return gcd(q, p % q);
    }

    public static void main(String[] args) {
        Solution_시간단축 solution = new Solution_시간단축();
        solution.solution(new int[]{2, 6, 8, 14});
    }

}
