package 프로그래머스.Programmers_멀쩡한사각형;

public class Solution_다시풀기 {
    public long solution(int w, int h) {
        long answer = 0;
        long lw = (long) w;
        long lh = (long) h;
        for (int i = 1; i < h; i++) {
            answer += (lw * i / lh);
        }

        return answer * 2;
    }
}
