package 프로그래머스.Programmers_다리를지나는트럭;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_다시시도 {

    public class Truck {
        private int weight;
        private int move;

        public Truck(int weight) {
            this.weight = weight;
            this.move = 1;
        }
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Truck> moveQ = new LinkedList<>();
        Queue<Truck> waitQ = new LinkedList<>();

        for (int truck_weight : truck_weights) {
            waitQ.offer(new Truck(truck_weight));
        }

        int answer = 0;
        int sum = 0;
        while (!waitQ.isEmpty() || !moveQ.isEmpty()) {
            answer++;

            if (moveQ.isEmpty()) {
                Truck truck = waitQ.poll();
                sum += truck.weight;
                moveQ.offer(truck);
                continue;
            }

            for (Truck truck : moveQ) {
                truck.move++;
            }

            if (moveQ.peek().move > bridge_length) {
                sum -= moveQ.poll().weight;
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
