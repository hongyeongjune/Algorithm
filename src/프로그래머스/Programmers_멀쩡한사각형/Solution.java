package 프로그래머스.Programmers_멀쩡한사각형;

public class Solution {
    public long solution(int w, int h) {
        long answer = 1;

        long width = (long) w;
        long height = (long) h;

        long gcd = gcd(width, height);

        long whole = width * height;
        long overlap = width + height - gcd;

        return answer = whole - overlap;
    }

    public long gcd(long w, long h) {
        long gcd;

        gcd = Math.max(w, h);

        while (1 < gcd) {

            if (w % gcd == 0 && h % gcd == 0) {
                return gcd;
            }
            gcd--;

        }
        return gcd = 1;
    }
}
