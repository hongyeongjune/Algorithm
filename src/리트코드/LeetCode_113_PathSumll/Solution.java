package 리트코드.LeetCode_113_PathSumll;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> answer = new ArrayList<>();

        List<Integer> pathList = new ArrayList<>();

        if (root == null) {
            return answer;
        }

        pathList.add(root.val);

        pathSum(root, targetSum, root.val, pathList, answer);

        return answer;
    }

    public void pathSum(TreeNode root, int targetSum, int sum, List<Integer> pathList, List<List<Integer>> answer) {
        if (targetSum == sum) {
            if (root.left == null && root.right == null) {
                answer.add(new ArrayList<>(pathList));
                return;
            }
        } else if (root.left == null && root.right == null) {
            return;
        }
        if (root.left != null) {
            pathList.add(root.left.val);
            pathSum(root.left, targetSum, sum + root.left.val, pathList, answer);
            pathList.remove(pathList.size() - 1);
        }
        if (root.right != null) {
            pathList.add(root.right.val);
            pathSum(root.right, targetSum, sum + root.right.val, pathList, answer);
            pathList.remove(pathList.size() - 1);
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}


