package 리트코드.LeetCode_310_MinimumHeightTrees;

import java.util.*;

public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);

        List<Set<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new HashSet<>());

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        List<Integer> leafNodes = new ArrayList<>();

        for (int i = 0; i < graph.size(); i++) {
            if (graph.get(i).size() == 1) leafNodes.add(i);
        }

        while (n > 2) {
            n -= leafNodes.size();
            List<Integer> newLeafNodes = new ArrayList<>();
            for (int leafNode : leafNodes) {
                int parent = graph.get(leafNode).iterator().next();
                graph.get(parent).remove(leafNode);
                if (graph.get(parent).size() == 1) newLeafNodes.add(parent);
            }
            leafNodes = newLeafNodes;
        }
        return leafNodes;
    }
}
