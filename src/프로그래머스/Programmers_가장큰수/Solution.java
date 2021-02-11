package 프로그래머스.Programmers_가장큰수;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] strings = new String[numbers.length];

        for(int i=0; i<numbers.length; i++) {
            strings[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });

        if(strings[0].equals("0")) {
            answer += "0";
        } else {
            for(int i=0; i<strings.length; i++) {
                answer += strings[i];
            }
        }

        return answer;
    }
}
