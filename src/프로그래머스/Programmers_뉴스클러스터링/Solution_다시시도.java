package 프로그래머스.Programmers_뉴스클러스터링;

import java.util.*;

public class Solution_다시시도 {

    public static int MUL = 65536;

    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        List<Character> list1 = new ArrayList<>();
        List<Character> list2 = new ArrayList<>();

        for (char c : str1.toCharArray()) {
            if (Character.isLetter(c)) list1.add(c);
        }
        for (char c : str2.toCharArray()) {
            if (Character.isLetter(c)) list2.add(c);
        }

        Collections.sort(list1);
        Collections.sort(list2);

        String[] arr1 = new String[list1.size() - 1];
        String[] arr2 = new String[list2.size() - 1];

        for (int i = 0; i < list1.size() - 1; i++) {
            arr1[i] = String.valueOf(list1.get(i)) + list1.get(i + 1);
        }
        for (int i = 0; i < list2.size() - 1; i++) {
            arr2[i] = String.valueOf(list2.get(i)) + list2.get(i + 1);
        }

        Map<String, Integer> map = new HashMap<>();

        for (String str : arr1) {
            map.merge(str, 1, Integer::sum);
        }

        int intersection = 0;
        int union = arr1.length;
        for (String str : arr2) {
            if (map.containsKey(str) && map.get(str) > 0) {
                map.merge(str, -1, Integer::sum);
                intersection++;
            } else if (map.containsKey(str) && map.get(str) <= 0) union++;
            else if (!map.containsKey(str)) union++;
        }


        return (int) (((double) intersection / (double) union) * 65536);
    }

    public static void main(String[] args) {
        Solution_다시시도 solution_다시시도 = new Solution_다시시도();
        solution_다시시도.solution("handshake", "shake hands");
    }
}
