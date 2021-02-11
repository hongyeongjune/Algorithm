package 프로그래머스.Programmers_2018카카오블라인드채용;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Solution {
    public static int solution(String[] lines) throws ParseException {
        int answer = 0;
        List<String[]> line = new ArrayList<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss.SSS");
        SimpleDateFormat secondDateFormat = new SimpleDateFormat("ss.SSS");
        List<Long> checkPoint = new ArrayList<>();

        for (String l : lines) {
            line.add(l.split(" "));
        }

        for (int i = 0; i < line.size(); i++) {
            Date date1 = simpleDateFormat.parse(line.get(i)[1]);
            Date date2 = secondDateFormat.parse(line.get(i)[2].substring(0, line.get(i)[2].length() - 1));
            line.get(i)[0] = simpleDateFormat.format(date1.getTime() - date2.getTime());
        }


        for (int i = 0; i < line.size(); i++) {
            checkPoint.add(simpleDateFormat.parse(line.get(i)[0]).getTime());
            checkPoint.add(simpleDateFormat.parse(line.get(i)[1]).getTime());
        }

        Collections.sort(checkPoint);

        int max = 0;

        for (int i = 0; i < checkPoint.size(); i++) {
            int count = 0;
            for (int j = 0; j < line.size(); j++) {
                if (check(
                        checkPoint.get(i),
                        checkPoint.get(i) + 999,
                        simpleDateFormat.parse(line.get(j)[0]).getTime(),
                        simpleDateFormat.parse(line.get(j)[1]).getTime())) {
                    count++;
                }
            }

            if (count > max) {
                max = count;
            }
        }

        return answer = max;
    }

    private static boolean check(long start, long end, long lineStart, long lineEnd) {

        if (lineEnd < start || lineStart >= end)
            return false;
        else return true;
    }

    public static void main(String[] args) throws ParseException {
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
