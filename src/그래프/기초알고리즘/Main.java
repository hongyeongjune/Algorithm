package 그래프.기초알고리즘;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static class ListGraph {

        private List<ArrayList<Integer>> graph;

        public ListGraph(int init) {
            this.graph = new ArrayList<ArrayList<Integer>>();

            for (int i = 0; i < init + 1; i++) {
                graph.add(new ArrayList<Integer>());
            }
        }

        public List<ArrayList<Integer>> getGraph() {
            return this.graph;
        }

        public List<Integer> getNode(int index) {
            return this.graph.get(index);
        }

        public void setBothWays(int x, int y) {
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        public void setOneWay(int x, int y) {
            graph.get(x).add(y);
        }

        public void printGraph() {
            for (int i = 1; i < graph.size(); i++) {
                System.out.print("정점" + i + "의 인접리스트");
                for (int j = 0; j < graph.get(i).size(); j++) {
                    System.out.print(" -> " + graph.get(i).get(j));
                }
                System.out.println("");
            }
        }
    }

    static class ArrayGraph {

        private int[][] graph;

        public ArrayGraph(int init) {
            this.graph = new int[init + 1][init + 1];
        }

        public int[][] getGraph() {
            return this.graph;
        }

        public void setBothWays(int x, int y) {
            graph[x][y] = graph[y][x] = 1;
        }

        public void setOneWay(int x, int y) {
            graph[x][y] = 1;
        }

        public void printGraph() {
            for (int i = 0; i < graph.length; i++) {
                for (int j = 0; j < graph.length; j++) {
                    System.out.print(graph[i][j] + " ");
                }
                System.out.println("");
            }
        }
    }

    public static void main(String[] args) {
        int init = 6;

        ListGraph listGraph = new ListGraph(init);
        ArrayGraph arrayGraph = new ArrayGraph(init);

        listGraph.setBothWays(1, 2);
        listGraph.setBothWays(1, 3);
        listGraph.setBothWays(2, 3);
        listGraph.setBothWays(2, 4);
        listGraph.setBothWays(3, 4);
        listGraph.setBothWays(3, 5);
        listGraph.setBothWays(4, 5);
        listGraph.setBothWays(4, 6);

        listGraph.printGraph();

        arrayGraph.setBothWays(1, 2);
        arrayGraph.setBothWays(1, 3);
        arrayGraph.setBothWays(2, 3);
        arrayGraph.setBothWays(2, 4);
        arrayGraph.setBothWays(3, 4);
        arrayGraph.setBothWays(3, 5);
        arrayGraph.setBothWays(4, 5);
        arrayGraph.setBothWays(4, 6);

        arrayGraph.printGraph();
    }
}
