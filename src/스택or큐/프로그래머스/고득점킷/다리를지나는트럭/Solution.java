package 스택or큐.프로그래머스.고득점킷.다리를지나는트럭;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public class Truck {
        int weight;
        int move;

        public Truck(int weight) {
            this.weight = weight;
            this.move = 1;
        }

        private void moving() {
            this.move++;
        }
    }
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Truck> moveQ = new LinkedList<>();
        Queue<Truck> waitQ = new LinkedList<>();

        for (int wait : truck_weights) {
            waitQ.offer(new Truck(wait));
        }

        int answer = 0;
        int sum = 0;

        while (!moveQ.isEmpty() || !waitQ.isEmpty()) {

            answer++;

            if (moveQ.isEmpty()) {
                Truck truck = waitQ.poll();
                sum += truck.weight;
                moveQ.offer(truck);
                continue;
            }

            for (Truck truck : moveQ) {
                truck.moving();
            }

            if (moveQ.peek().move > bridge_length) {
                Truck truck = moveQ.poll();
                sum -= truck.weight;
            }

            if (!waitQ.isEmpty() && sum + waitQ.peek().weight <= weight) {
                Truck truck = waitQ.poll();
                sum += truck.weight;
                moveQ.offer(truck);
            }
        }

        return answer;
    }
}
