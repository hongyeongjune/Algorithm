package 리트코드.LeetCode_1202_SmallestStringWithSwaps;

import java.util.*;

public class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int[] parent = new int[s.length()];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (List<Integer> pair : pairs) {
            unionParent(parent, pair.get(0), pair.get(1));
        }

        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            int root = getParent(parent, i);
            map.computeIfAbsent(root, key -> new PriorityQueue<>()).offer(c[i]);
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < c.length; i++) {
            stringBuilder.append(
                    map.get(getParent(parent, i)).poll()
            );
        }

        return stringBuilder.toString();
    }

    private static int getParent(int[] parent, int x) {
        if (parent[x] == x) return x;
        return parent[x] = getParent(parent, parent[x]);
    }

    private static void unionParent(int[] parent, int a, int b) {
        a = getParent(parent, a);
        b = getParent(parent, b);
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> testCase = new ArrayList<>();
        List<Integer> case1 = Arrays.asList(0, 3);
        List<Integer> case2 = Arrays.asList(1, 2);
        List<Integer> case3 = Arrays.asList(0, 2);
        testCase.add(case1);
        testCase.add(case2);
        solution.smallestStringWithSwaps("dcab", testCase);
    }
}
