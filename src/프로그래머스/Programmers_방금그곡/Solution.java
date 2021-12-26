package 프로그래머스.Programmers_방금그곡;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Solution {

    public static final Map<String, Character> map = new HashMap<>();

    public String solution(String m, String[] musicinfos) throws ParseException {

        List<Music> answer = new ArrayList<>();

        toMap();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");

        String user = change(m);

        for(int i=0; i<musicinfos.length; i++) {
            String[] music = musicinfos[i].split(",");
            long diff = (simpleDateFormat.parse(music[1]).getTime() - simpleDateFormat.parse(music[0]).getTime()) / 60000;

            String change = change(music[3]);
            if(change.length() > diff) {
                change = change.substring(0, (int) diff);
            }
            else {
                String temp = change;
                int quotient = (int) (diff / temp.length());
                for(int j=1; j<quotient; j++) {
                    change += temp;
                }
                int remainder = (int) (diff % temp.length());
                if(remainder > 0) {
                    change += temp.substring(0, remainder);
                }
            }

            if(change.contains(user)) {
                answer.add(new Music(music[2], diff, i));
            }
        }

        if(answer.size() > 1) {
            answer.sort(Comparator.comparing(Music::getTime).reversed().thenComparing(Music::getIndex));
        }

        return answer.size() == 0 ? "(None)" : answer.get(0).musicInfo;
    }

    public String change(String music) {
        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;
        while(index < music.length()) {
            if(index+1 < music.length() && music.charAt(index+1) == '#') {
                stringBuilder.append(map.get(String.valueOf(music.charAt(index)) + music.charAt(index+1)));
                index+=2;
            }
            else {
                stringBuilder.append(map.get(String.valueOf(music.charAt(index))));
                index++;
            }
        }

        return stringBuilder.toString();
    }

    public class Music {
        String musicInfo;
        long time;
        int index;

        public long getTime() {
            return time;
        }

        public int getIndex() {
            return index;
        }

        public Music(String musicInfo, long time, int index) {
            this.musicInfo = musicInfo;
            this.time = time;
            this.index = index;
        }
    }

    public void toMap() {
        map.put("C", 'C');
        map.put("C#", 'J');
        map.put("D", 'D');
        map.put("D#", 'K');
        map.put("E", 'E');
        map.put("F", 'F');
        map.put("F#", 'M');
        map.put("G", 'G');
        map.put("G#", 'N');
        map.put("A", 'A');
        map.put("A#", 'H');
        map.put("B", 'B');
    }

    public static void main(String[] args) throws ParseException {
        Solution solution = new Solution();
        solution.solution("ABCDEFG", new String[]{
                "12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"
        });
    }
}
