package 리트코드.LeetCode_207_CourseSchedule;

import java.util.*;

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {


        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
            inDegree[prerequisites[i][0]]++;
        }

        return topologySort(graph, inDegree, numCourses);
    }

    private boolean topologySort(List<List<Integer>> graph, int[] inDegree, int numCourses) {

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();

            list.add(node);

            for (int i = 0; i < graph.get(node).size(); i++) {
                int next = graph.get(node).get(i);
                inDegree[next]--;
                if (inDegree[next] == 0) queue.offer(next);
            }
        }

        if (list.size() == numCourses) return true;

        return false;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.canFinish(20, new int[][]{
                {0, 10}, {3, 18}, {5, 5}, {6, 11}, {11, 14}, {13, 1}, {15, 1}, {17, 4}
        });
    }


}
