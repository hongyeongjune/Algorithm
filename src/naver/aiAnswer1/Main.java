package naver.aiAnswer1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {


    public static void main(String[] args) {

        String s = "bab??a";

        String str = solution(s);

        System.out.println(str);

    }

    private static String solution(String s) {

        int length = s.length() - 1;
        String str = s;

        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == '?') {
                if(i == 0) {
                    str = str.charAt(length - i) + str.substring(i+1, length + 1);
                }
                if(i * 2 == length) {
                    str = str.substring(0, i) + 'a' + str.substring(i + 1, length + 1);
                }
                if(str.charAt(i) == '?' && str.charAt(length - i) == '?') {
                    str = str.substring(0, i) + 'a' + str.substring(i + 1, length + 1);
                }
                else {
                    str = str.substring(0, i) + str.charAt(length - i) + str.substring(i + 1, length + 1);
                }
            }
        }

        return str;

    }
}
