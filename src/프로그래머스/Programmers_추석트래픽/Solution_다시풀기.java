package 프로그래머스.Programmers_추석트래픽;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Solution_다시풀기 {
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
        for (Long time : timeList) {
            int count = 0;
            for (Log log : logList) {
                if (log.isInTheZone(time, time + 999)) count++;
            }
            answer = Math.max(answer, count);
        }
        return answer;
    }

    public class Log {
        private long start;
        private long end;

        public long getStart() {
            return start;
        }

        public Log(String line) throws ParseException {
            String[] split = line.split(" ");
            Date end = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").parse(split[0] + " " + split[1]);
            this.end = end.getTime();
            split = split[2].split("s");
            long time = (long) (1000 * Double.parseDouble(split[0]));
            this.start = this.end - time;
        }

        public boolean isInTheZone(long start, long end) {
            if (this.start >= end || this.end < start) return false;
            return true;
        }
    }
}
