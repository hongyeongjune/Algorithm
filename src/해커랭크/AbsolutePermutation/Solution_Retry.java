package 해커랭크.AbsolutePermutation;

public class Solution_Retry {
    static int[] absolutePermutation(int n, int k) {

        int[] answer = new int[n];

        //k가 0이면 1 ~ n 까지 넣기
        if (k == 0) {
            for (int i = 0; i < n; i++) {
                answer[i] = i + 1;
            }
            return answer;
        }

        //규칙 1 : 1 ~ n/2 까지 k를 더하고 n/2+1 ~ n까지 k를 뺀다.
        //1+2
        //2+2
        //3-2
        //4-2
        //규칙 2 : k로 나눈 값이 짝수 일 때 더하고 k로 나눈 값이 홀수 일 때 뺀다.
        //ex1)
        //1+1
        //2-1
        //3+1
        //4-1
        //ex2)
        //1+2
        //2+2
        //3-2
        //4-2
        //5+2
        //6+2
        //7-2
        //8-2
        // -> 결국 규칙 1과 규칙 2가 같다.
        // -> 홀수는 절대 안됨
        // -> 짝수만 되고, k에 2를 곱했을 때, n보다 커지면 절대 안됨.
        if (n % (k * 2) != 0) return new int[]{-1};

        for (int i = 0; i < n; i++) {
            if ((i / k) % 2 == 0) answer[i] = i + k + 1;
            else answer[i] = i - k + 1;
        }

        return answer;
    }
}
