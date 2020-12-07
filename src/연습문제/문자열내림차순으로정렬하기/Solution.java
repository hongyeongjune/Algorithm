package 연습문제.문자열내림차순으로정렬하기;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static String solution(String s) {
        String answer = "";
        String[] temp = s.split("");

        Arrays.sort(temp, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        for (int i = 0; i < temp.length; i++) answer += temp[i];

        return answer;
    }
}
