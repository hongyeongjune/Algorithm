package 프로그래머스.Programmers_직업군추천하기;

public class Solution {
    public String solution(String[] table, String[] languages, int[] preference) {
        String answer = "";
        int max = Integer.MIN_VALUE;
        for (String t : table) {
            String[] split = t.split(" ");

            int sum = 0;

            for (int i = 1; i < split.length; i++) {
                int score = split.length - i;

                for (int j = 0; j < languages.length; j++) {
                    if (languages[j].equals(split[i])) {
                        sum += (preference[j] * score);
                    }
                }
            }

            if (max <= sum) {
                if (max == sum) {
                    if (answer.compareTo(split[0]) < 0) {
                        continue;
                    }
                }
                max = sum;
                answer = split[0];
            }

        }

        return answer;
    }
}
