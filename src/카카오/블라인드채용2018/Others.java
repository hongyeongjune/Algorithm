package 카카오.블라인드채용2018;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Others {

    static class Log {
        private long start = 0;
        private long duration = 0;
        private long end = 0;

        public Log(String line) {
            String[] split = line.split(" ");
            String date = split[0] + " " + split[1];
            try {
                Date startDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(date);
                this.end = startDate.getTime();

                String[] split2 = split[2].split("s");
                double parse = Double.parseDouble(split2[0]);
                this.duration = (long) (parse * 1000);

                this.start = this.end - this.duration;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public boolean isIn(long checkPointStart, long checkPointEnd) {
            if (this.end < checkPointStart || this.start >= checkPointEnd)
                return false;
            else return true;
        }
    }

    public static int solution(String[] lines) {
        int answer = 0;
        List<Long> checkPoint = new ArrayList<>();
        List<Log> logs = new ArrayList<>();

        for (String line : lines) {
            Log log = new Log(line);
            checkPoint.add(log.start);
            checkPoint.add(log.end);
            logs.add(log);
        }

        Collections.sort(checkPoint);

        int top = 0;
        for (int i = 0; i < checkPoint.size(); i++) {
            int count = 0;
            for (Log log : logs) {
                if (log.isIn(checkPoint.get(i), checkPoint.get(i) + 999))
                    count++;
            }
            if (count > top) {
                top = count;
            }
        }

        answer = top;
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{
                "2016-09-15 20:59:57.421 0.351s",
                "2016-09-15 20:59:58.233 1.181s",
                "2016-09-15 20:59:58.299 0.8s",
                "2016-09-15 20:59:58.688 1.041s",
                "2016-09-15 20:59:59.591 1.412s",
                "2016-09-15 21:00:00.464 1.466s",
                "2016-09-15 21:00:00.741 1.581s",
                "2016-09-15 21:00:00.748 2.31s",
                "2016-09-15 21:00:00.966 0.381s",
                "2016-09-15 21:00:02.066 2.62s"
        }));
    }
}
