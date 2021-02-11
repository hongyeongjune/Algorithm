package 우아한테크코스.프로그래밍4;

import java.util.HashMap;
import java.util.Iterator;

public class Solution {

    public class Index {
        private int i;
        private int j;

        public Index(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public int solution(int n, int[][] board) {
        int answer = 0;
        HashMap<Integer, Index> hashMap = new HashMap<>();

        hashMap.put(0, new Index(0, 0));

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                hashMap.put(board[i][j], new Index(i, j));
            }
        }

        Iterator<Integer> iterator = hashMap.keySet().iterator();

        for (int i = 0; i < (n * n); i++) {

            if (iterator.hasNext()) {
                int temp1 = iterator.next();

                int horizontal = Math.abs(hashMap.get(temp1).i - hashMap.get(temp1 + 1).i);
                int vertical = Math.abs(hashMap.get(temp1).j - hashMap.get(temp1 + 1).j);

                int x = Math.abs(n - horizontal);
                int y = Math.abs(n - vertical);

                answer += Math.min(x, horizontal);
                answer += Math.min(y, vertical);
            }

        }


        return answer + (n * n);
    }

}
