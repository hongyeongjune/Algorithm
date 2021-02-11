package 프로그래머스.Programmers_풍선터뜨리기;

import java.util.HashSet;

public class Solution {
    public int solution(int[] a) {
        HashSet<Integer> hashSet = new HashSet<>();
        int min = a[0];
        for (int i = 1; i < a.length; i++) {
            hashSet.add(min);
            min = Math.min(a[i], min);
        }

        min = a[a.length - 1];
        for (int i = a.length - 2; i >= 0; i--) {
            hashSet.add(min);
            min = Math.min(a[i], min);
        }

        return hashSet.size();
    }
}
