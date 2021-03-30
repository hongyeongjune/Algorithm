package 프로그래머스.Programmers_광고삽입;

public class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {

        int[] watch = new int[360000];

        int playTime = stringToSecond(play_time);
        int advTime = stringToSecond(adv_time);

        for (String log : logs) {

            String[] split = log.split("-");
            int start = stringToSecond(split[0]);
            int end = stringToSecond(split[1]);

            for (int i = start; i < end; i++) {
                watch[i]++;
            }
        }

        long sum = 0;
        for (int i = 0; i < advTime; i++) {
            sum += watch[i];
        }

        long max = sum;
        int start = 0;
        int end = advTime;

        int answer = 0;

        while (end <= playTime) {
            sum -= watch[start];
            sum += watch[end];

            if (sum > max) {
                max = sum;
                answer = start + 1;
            }
            start++;
            end++;
        }

        return secondToString(answer);
    }


    private int stringToSecond(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 * 60 + Integer.parseInt(split[1]) * 60 + Integer.parseInt(split[2]);
    }

    private String secondToString(int time) {
        int hour = time / 3600;
        time %= 3600;
        int minute = time / 60;
        int second = time % 60;

        String hh = hour > 9 ? String.valueOf(hour) : "0" + hour;
        String mm = minute > 9 ? String.valueOf(minute) : "0" + minute;
        String ss = second > 9 ? String.valueOf(second) : "0" + second;

        return hh + ":" + mm + ":" + ss;
    }
}
