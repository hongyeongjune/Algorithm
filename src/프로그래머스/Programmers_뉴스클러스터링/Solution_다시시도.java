package 프로그래머스.Programmers_뉴스클러스터링;

import java.util.*;

public class Solution_다시시도 {

    public static int MUL = 65536;

    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        for (int i = 0; i < str1.length() - 1; i++) {
            char first = str1.charAt(i);
            char second = str1.charAt(i + 1);
            if (first >= 'a' && first <= 'z' && second >= 'a' && second <= 'z') {
                list1.add(String.valueOf(first) + second);
            }
        }

        for (int i = 0; i < str2.length() - 1; i++) {
            char first = str2.charAt(i);
            char second = str2.charAt(i + 1);
            if (first >= 'a' && first <= 'z' && second >= 'a' && second <= 'z') {
                list2.add(String.valueOf(first) + second);
            }
        }

        Collections.sort(list1);
        Collections.sort(list2);

        int intersection = 0;
        int union = 0;
        for (String str : list1) {
            if (list2.remove(str)) {
                intersection++;
            }
            union++;
        }

        for (int i = 0; i < list2.size(); i++) union++;

        if (union == 0) return MUL;

        return (int) (((double) intersection / (double) union) * 65536);
    }

    public static void main(String[] args) {
        Solution_다시시도 solution_다시시도 = new Solution_다시시도();
        solution_다시시도.solution("handshake", "shake hands");
    }
}
