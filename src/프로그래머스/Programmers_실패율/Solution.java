package 프로그래머스.Programmers_실패율;

import java.util.*;

public class Solution {

    public class FailureRate {

        int stage;
        double failureRate;

        public FailureRate(int stage, double failureRate) {
            this.stage = stage;
            this.failureRate = failureRate;
        }

        public double getFailureRate() {
            return failureRate;
        }
    }

    public int[] solution(int N, int[] stages) {

        int[] check = new int[N + 1];

        for (int stage : stages) {
            if (stage <= N) {
                check[stage]++;
            }
        }

        List<FailureRate> list = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            int sum = 0;
            for (int j = 1; j < i; j++) sum += check[j];

            if (stages.length - sum != 0)
                list.add(new FailureRate(i, (double) check[i] / (double) (stages.length - sum)));
            else list.add(new FailureRate(i, 0));
        }

        list.sort(Comparator.comparing(FailureRate::getFailureRate).reversed());

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            answer[i] = list.get(i).stage;


        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).stage + "           " + list.get(i).failureRate);
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3});
    }
}
