package 스택or큐.프로그래머스.고득점킷.다리를지나는트럭;

import java.util.LinkedList;
import java.util.Queue;

public class Retry {

    public static class Truck {

        int weight;
        int move;

        public Truck(int weight) {
            this.weight = weight;
            this.move = 1;
        }

    }


    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int sum = 0;
        Queue<Truck> moveQ = new LinkedList<>();
        Queue<Truck> waitQ = new LinkedList<>();

        for (Integer truck_weight : truck_weights) {
            waitQ.offer(new Truck(truck_weight));
        }

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
                sum -= moveQ.peek().weight;
                moveQ.poll();
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
