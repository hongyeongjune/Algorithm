package HeapSort.프로그래머스.더맵게;

public class Solution {

    public static void heapify(int[] heap) {

        for(int i=1; i<heap.length; i++) {
            int child = i;
            do {
                int root = (child - 1) / 2;
                if(heap[root] < heap[child]) {
                    int temp = heap[root];
                    heap[root] = heap[child];
                    heap[child] = temp;
                }
                child = root;
            }while(child != 0);
        }

        for(int i=heap.length-1; i>=0; i--) {
            int temp = heap[0];
            heap[0] = heap[i];
            heap[i] = temp;

            int root = 0;
            int child = 1;

            do{
                child = 2 * root +1;
                if(child < i-1 && heap[child] < heap[child + 1]) {
                    child++;
                }

                if(child < i && heap[root] < heap[child]) {
                    temp = heap[root];
                    heap[root] = heap[child];
                    heap[child] = temp;
                }
                root = child;
            }while (child < i);
        }

    }
    public int solution(int[] scoville, int K) {
        int answer = 0;

        heapify(scoville);

        for(int i=0; i<scoville.length; i++) {

            if(scoville[i] < K) {
                if(i+1 == scoville.length) return answer = -1;
                scoville[i+1] = scoville[i] + scoville[i+1] * 2;
                answer++;
                heapify(scoville);
            }
        }
        return answer;
    }
}
