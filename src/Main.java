import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private int v;
    private LinkedList[] adjacency;

    public Main(int v) {
        this.v = v;
        adjacency = new LinkedList[v+1];

        for(int i=1; i<=v; i++) {
            adjacency[i] = new LinkedList();
        }
    }

    public static void main(String[] args) {
        Main main = new Main(7);
        boolean[] visited = new boolean[8];

        main.addEdge(1,2);
        main.addEdge(1,3);
        main.addEdge(2,3);
        main.addEdge(2,4);
        main.addEdge(2,5);
        main.addEdge(3,6);
        main.addEdge(3,7);

        main.dfs(1, visited);
    }

    private void addEdge(int v, int w) {
        adjacency[v].add(w);
    }

    private void dfs(int v, boolean[] visited) {

        visited[v] = true;
        System.out.println(v);

        Iterator<Integer> iterator = adjacency[v].listIterator();
        while(iterator.hasNext()) {
            int temp = iterator.next();
            if(!visited[temp])
                dfs(temp, visited);

        }
    }
}
