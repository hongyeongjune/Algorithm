package 프로그래머스.Programmers_전화번호목록;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        });

        HashMap<String, Integer> hashMap = new HashMap<>();
        for(String phone : phone_book) hashMap.put(phone, phone.length());

        for(int i=0; i<phone_book.length; i++) {
            for(int j=i+1; j<phone_book.length; j++) {
                if(phone_book[i].equals(phone_book[j].substring(0, hashMap.get(phone_book[i])))){
                    return answer = false;
                }
            }
        }
        return answer = true;
    }
}