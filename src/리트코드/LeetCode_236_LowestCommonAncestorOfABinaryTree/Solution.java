package 리트코드.LeetCode_236_LowestCommonAncestorOfABinaryTree;

public class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // 맨 아래서 부터 시작해서 계속해서 위로 올리면서 보는방식
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // 확인
        if (root == null || root == p || root == q) return root;

        // 이진트리이므로 왼쪽 오른쪽 계속해서 아래로 내려간다.
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 올리기
        if (left == null) return right;
        else if (right == null) return left;
        else return root;
    }
}
