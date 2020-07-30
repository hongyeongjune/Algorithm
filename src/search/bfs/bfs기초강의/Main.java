package search.bfs.bfs기초강의;

import java.util.*;

public class Main {

    private int V;
    private LinkedList<Integer> linkedList[];

    public Main(int V) {
        this.V = V;
        linkedList = new LinkedList[V+1];
        for(int i=1; i<=V; i++) {
            linkedList[i] = new LinkedList();
        }
    }

    private void addEdge(int V, int W) {
        linkedList[V].add(W);
    }

    public static void main(String[] args) {
        Main main = new Main(7);
        main.addEdge(1,2);
        main.addEdge(1,3);
        main.addEdge(2,3);
        main.addEdge(2,4);
        main.addEdge(2,5);
        main.addEdge(3,6);
        main.addEdge(3,7);

        main.bfs(1);
    }

    private void bfs(int start) {

        boolean[] visited = new boolean[V+1];
        Queue<Integer> queue = new LinkedList<Integer>();

        visited[start] = true;
        queue.add(start);

        while(!queue.isEmpty()) {
            start = queue.poll();
            System.out.println(start);

            Iterator<Integer> iterator = linkedList[start].listIterator();
            while(iterator.hasNext()) {
                int temp = iterator.next();
                if(!visited[temp]) {
                    visited[temp] = true;
                    queue.add(temp);
                }
            }

        }

    }
}
