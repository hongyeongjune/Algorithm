package 프로그래머스.Programmers_뉴스클러스터링;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public static int MULTIPLE = 65536;

    public int solution(String str1, String str2) {
        int answer = 0;
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        for (int i = 0; i < str1.length() - 1; i++) {
            char first = str1.charAt(i);
            char second = str1.charAt(i + 1);
            if (first >= 'A' && first <= 'Z' && second >= 'A' && second <= 'Z') {
                list1.add(String.valueOf(first) + String.valueOf(second));
            }
        }

        for (int i = 0; i < str2.length() - 1; i++) {
            char first = str2.charAt(i);
            char second = str2.charAt(i + 1);
            if (first >= 'A' && first <= 'Z' && second >= 'A' && second <= 'Z') {
                list2.add(String.valueOf(first) + String.valueOf(second));
            }
        }

        Collections.sort(list1);
        Collections.sort(list2);

        List<String> intersection = new ArrayList<>();
        List<String> union = new ArrayList<>();

        for (String str : list1) {
            if (list2.remove(str)) {
                intersection.add(str);
            }
            union.add(str);
        }

        for (String str : list2) {
            union.add(str);
        }

        double jaccard = 0;

        if (union.size() == 0) {
            jaccard = 1;
        } else {
            jaccard = (double) intersection.size() / (double) union.size();
        }

        return (int) (jaccard * MULTIPLE);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution("FRANCE", "french");
    }
}
