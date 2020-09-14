package 스택or큐.프로그래머스.고득점킷.주식가격;

public class Retry {
    public static int[] solution(int[] prices) {

        int[] answer = new int[prices.length];


        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] <= prices[j]) {
                    answer[i]++;
                } else if (prices[i] > prices[j]) {
                    answer[i]++;
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        solution(new int[]{1, 2, 3, 2, 3});
    }
}
