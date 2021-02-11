package 프로그래머스.Programmers_이진변환반복하기;

public class Solution {

    public static int[] solution(String s) {
        int[] answer = new int[2];

        while (!s.equals("1")) {
            String temp = "";
            int length = 0;
            for (char c : s.toCharArray()) {
                if (c == '1') {
                    temp += c;
                    length++;
                } else {
                    answer[1] += 1;
                }
            }

            s = Integer.toBinaryString(length);
            answer[0] += 1;
        }

        return answer;
    }

}
