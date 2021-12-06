package 프로그래머스.Programmers_길찾기게임;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public static int index;

    public int[][] solution(int[][] nodeinfo) {

        Node[] nodes = new Node[nodeinfo.length];

        for(int i=0; i<nodeinfo.length; i++) {
            nodes[i] = new Node(nodeinfo[i][0], nodeinfo[i][1], i+1, null, null);
        }

        Arrays.sort(nodes, Comparator.comparing(Node::getY).reversed().thenComparing(Node::getX));

        Node root = nodes[0];
        for(int i=1; i<nodes.length; i++) {
            insertNode(root, nodes[i]);
        }

        int[][] answer = new int[2][nodes.length];

        index = 0;
        preOrder(nodes[0], answer);
        index = 0;
        postOrder(nodes[0], answer);

        return answer;
    }

    private void insertNode(Node parent, Node child) {
        if(parent.x > child.x) {
            if(parent.left == null) parent.left = child;
            else insertNode(parent.left, child);
        }
        else {
            if(parent.right == null) parent.right = child;
            else insertNode(parent.right, child);
        }
    }

    private void preOrder(Node node, int[][] answer) {
        if(node != null) {
            answer[0][index++] = node.value;
            preOrder(node.left, answer);
            preOrder(node.right, answer);
        }
    }

    private void postOrder(Node node, int[][] answer) {
        if(node != null) {
            postOrder(node.left, answer);
            postOrder(node.right, answer);
            answer[1][index++] = node.value;
        }
    }

    public class Node {
        int x;
        int y;
        int value;
        Node left;
        Node right;


        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public Node(int x, int y, int value, Node left, Node right) {
            this.x = x;
            this.y = y;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
