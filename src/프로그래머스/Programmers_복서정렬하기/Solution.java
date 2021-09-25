package 프로그래머스.Programmers_복서정렬하기;

import java.util.Arrays;

public class Solution {
    public int[] solution(int[] weights, String[] head2head) {
        HeadToHead[] headToHeads = new HeadToHead[weights.length];
        for (int i = 0; i < head2head.length; i++) {
            char[] arr = head2head[i].toCharArray();
            double total = 0;
            double win = 0;
            int winHeavy = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == 'W') {
                    win++;
                    if (weights[i] < weights[j]) winHeavy++;
                }
                if (arr[j] != 'N') total++;
            }
            double winRate = win / total;
            if (total > 0)
                headToHeads[i] = new HeadToHead(i, winRate, winHeavy, weights[i]);
            else headToHeads[i] = new HeadToHead(i, 0, winHeavy, weights[i]);
        }

        Arrays.sort(headToHeads, (o1, o2) -> {
            if (o1.winRate != o2.winRate) {
                return o2.winRate - o1.winRate > 0 ? 1 : -1;
            } else if (o1.winHeavy != o2.winHeavy) {
                return o2.winHeavy - o1.winHeavy;
            } else if (o1.weight != o2.weight) {
                return o2.weight - o1.weight;
            } else {
                return o1.index - o2.index;
            }
        });

        int[] answer = new int[headToHeads.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = headToHeads[i].index + 1;
        }
        return answer;
    }

    public class HeadToHead {
        private int index;
        private double winRate;
        private int winHeavy;
        private int weight;

        public HeadToHead(int index, double winRate, int winHeavy, int weight) {
            this.index = index;
            this.winRate = winRate;
            this.winHeavy = winHeavy;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[]{60, 70, 60}, new String[]{"NNN", "NNN", "NNN"});
    }
}
