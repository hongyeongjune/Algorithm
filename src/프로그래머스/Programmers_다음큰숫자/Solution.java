package 프로그래머스.Programmers_다음큰숫자;

public class Solution {
    public int solution(int n) {

        int answer = 0;

        String binary = Integer.toBinaryString(n);

        int count = 0;
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') count++;
        }

        while (n <= 1000000) {
            String temp = Integer.toBinaryString(++n);
            int tempCount = 0;
            for (int i = 0; i < temp.length(); i++) {
                if (temp.charAt(i) == '1') tempCount++;
            }

            if (count == tempCount) return Integer.parseInt(temp, 2);
        }

        return answer;
    }
}
