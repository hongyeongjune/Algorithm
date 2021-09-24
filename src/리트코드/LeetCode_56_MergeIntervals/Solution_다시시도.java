package 리트코드.LeetCode_56_MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution_다시시도 {
    public int[][] merge(int[][] intervals) {
        List<Interval> list = new ArrayList<>();

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        Interval before = new Interval(intervals[0][0], intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            Interval now = new Interval(intervals[i][0], intervals[i][1]);

            if (before.end >= now.start) {
                before.end = Math.max(before.end, now.end);
            } else {
                list.add(before);
                before = now;
            }
        }

        if (!list.contains(before)) list.add(before);

        int[][] answer = new int[list.size()][2];
        for (int i = 0; i < answer.length; i++) {
            answer[i][0] = list.get(i).start;
            answer[i][1] = list.get(i).end;
        }

        return answer;
    }

    public class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
