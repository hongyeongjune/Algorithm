package 크루스칼알고리즘.기초알고리즘;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static int[] parent;
    public static List<Edge> edgeList;
    public static int n = 7;
    public static int m = 11;

    public static void main(String[] args) {
        edgeList = new ArrayList<>();
        edgeList.add(new Edge(1,7,12));
        edgeList.add(new Edge(1,4,28));
        edgeList.add(new Edge(1,2,67));
        edgeList.add(new Edge(1,5,17));
        edgeList.add(new Edge(2,4,24));
        edgeList.add(new Edge(2,5,62));
        edgeList.add(new Edge(3,5,20));
        edgeList.add(new Edge(3,6,37));
        edgeList.add(new Edge(4,7,13));
        edgeList.add(new Edge(5,6,45));
        edgeList.add(new Edge(5,7,73));

        parent = new int[n];

        for(int i=0; i<n; i++) {
            parent[i] = i;
        }

        Collections.sort(edgeList);

        int sum = 0;
        for(int i=0; i<edgeList.size(); i++) {
            Edge edge = edgeList.get(i);
            if(!findParent(parent, edge.node[0]-1, edge.node[1]-1)) {
                sum+= edge.distance;
                unionParent(parent, edge.node[0]-1, edge.node[1]-1);
            }
        }

        System.out.println(sum);
    }

    private static int getParent(int[] parent, int x) {
        if(parent[x] == x) return x;
        return parent[x] = getParent(parent, parent[x]);
    }

    private static void unionParent(int[] parent, int a, int b) {
        a = getParent(parent, a);
        b = getParent(parent, b);
        if(a < b) parent[b] = a;
        else parent[a] = b;
    }

    private static boolean findParent(int[] parent, int a, int b) {
        a = getParent(parent, a);
        b = getParent(parent, b);
        if(a == b) return true;
        else return false;
    }

    private static class Edge implements Comparable<Edge>{
        int[] node = new int[2];
        int distance;
        public Edge(int a, int b, int distance) {
            this.node[0] = a;
            this.node[1] = b;
            this.distance = distance;
        }
        @Override
        public int compareTo(Edge o) {
            return this.distance-o.distance;
        }
    }
}
