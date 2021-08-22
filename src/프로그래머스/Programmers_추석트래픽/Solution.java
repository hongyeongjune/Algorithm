package 프로그래머스.Programmers_추석트래픽;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Solution {
    public int solution(String[] lines) throws ParseException {

        List<Log> logList = new ArrayList<>();
        List<Long> timeList = new ArrayList<>();

        for (String line : lines) {
            Log log = new Log(line);
            logList.add(log);
            timeList.add(log.start);
            timeList.add(log.end);
        }

        Collections.sort(timeList);

        int answer = 0;

        for (int i = 0; i < timeList.size(); i++) {
            int count = 0;
            for (Log log : logList) {
                if (log.isInTheZone(timeList.get(i), timeList.get(i) + 999)) {
                    count++;
                }
            }
            answer = Math.max(answer, count);
        }

        return answer;
    }

    public class Log {
        private long start;
        private long end;
        private long during;

        public Log(String line) throws ParseException {
            String[] split = line.split(" ");
            String date = split[0] + " " + split[1];
            Date end = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(date);
            this.end = end.getTime();

            split = split[2].split("s");
            double time = Double.parseDouble(split[0]);
            this.during = (long) (1000 * time);

            this.start = this.end - this.during;
        }

        public boolean isInTheZone(long start, long end) {
            if (this.start >= end || this.end < start) return false;
            return true;
        }
    }

    public static void main(String[] args) throws ParseException {
        Solution solution = new Solution();
        solution.solution(new String[]{
                "2016-09-15 01:00:04.001 2.0s",
                "2016-09-15 01:00:07.000 2s"
        });
    }
}
