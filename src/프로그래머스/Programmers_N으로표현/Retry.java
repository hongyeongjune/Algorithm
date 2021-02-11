package 프로그래머스.Programmers_N으로표현;

public class Retry {

    int answer = -1;

    public int solution(int N, int number) {

        dp(N, number, 0, 0, "");

        return answer;
    }

    private void dp(int n, int number, int count, int result, String calculate) {

        if (count > 8) return;

        if (result == number) {
            if (count < answer || answer == -1) {
                answer = count;
            }
            return;
        }

        int nn = 0;
        for (int i = 0; i < 8; i++) {
            nn = nn * 10 + n;
            dp(n, number, count + i + 1, result + nn, "+");
            dp(n, number, count + i + 1, result - nn, "-");
            dp(n, number, count + i + 1, result * nn, "*");
            dp(n, number, count + i + 1, result / nn, "/");
        }
    }
}
