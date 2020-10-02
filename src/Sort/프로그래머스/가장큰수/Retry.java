package Sort.프로그래머스.가장큰수;

import java.util.Arrays;
import java.util.Comparator;

public class Retry {
    public static String solution(int[] numbers) {
        String answer = "";
        String[] number = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            number[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(number, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        if (number[0].equals("0"))
            answer = "0";
        else {
            for (String sort : number) {
                answer += sort;
            }
        }

        return answer;
    }

}
