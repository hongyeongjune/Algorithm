package 프로그래머스.Programmers_2020카카오블라인드채용.문자열압축;

public class Solution {
    public int solution(String s) {
        int answer = 0;

        for (int i = 1; i < (s.length() / 2) + 1; i++) {

            String prefix = "";
            int sum = 0;
            int count = 1;

            for (int j = 0; j < s.length(); ) {
                int start = j;
                if (j + i > s.length())
                    j = s.length();

                String temp = s.substring(start, j);

                if (temp.equals(prefix)) {
                    count++;
                } else {
                    if (count != 1) {
                        sum += (int) Math.log10(count) + 1;
                    }
                    count = 1;
                    sum += prefix.length();
                    prefix = temp;
                }
            }

            sum += prefix.length();
            if (count != 1) sum += (int) Math.log(count) + 1;

        }
        return answer;
    }
}
