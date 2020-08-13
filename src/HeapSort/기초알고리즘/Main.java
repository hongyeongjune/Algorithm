package HeapSort.기초알고리즘;

public class Main {

    public static void main(String[] args) {
        int[] heap = {10,26, 5, 37, 1, 61, 11, 59, 15, 48, 19};
        int number = heap.length;

        for(int i=1; i<number; i++) {
            int child = i;
            do{
                int root = (child - 1) / 2;
                if (heap[root] < heap[child]) {
                    int temp = heap[root];
                    heap[root] = heap[child];
                    heap[child] = temp;
                }
                child = root;
            }while(child != 0);
        }

        for(int i=number-1; i>=0; i--) {
            int temp = heap[0];
            heap[0] = heap[i];
            heap[i] = temp;

            int root = 0;
            int child = 1;
            do {
                child = 2 * root + 1;
                if(child < i-1 && heap[child] < heap[child + 1]) {
                    child++;
                }

                if(child < i && heap[root] < heap[child]) {
                    temp = heap[root];
                    heap[root] = heap[child];
                    heap[child] = temp;
                }
                root = child;
            } while (child < i);
        }
    }
}
