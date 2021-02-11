package 프로그래머스.Programmers_베스트앨범;

import java.util.*;

public class Retry {
    public static int[] solution(String[] genres, int[] plays) {

        HashMap<String, List<Song>> hashMap = new HashMap<>();
        HashMap<String, Integer> sumMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            if (hashMap.get(genres[i]) != null) {
                int sum = sumMap.get(genres[i]);
                sum += plays[i];
                sumMap.put(genres[i], sum);

                List<Song> songs = hashMap.get(genres[i]);
                songs.add(new Song(plays[i], i));
                hashMap.put(genres[i], songs);
            } else {
                int sum = plays[i];
                sumMap.put(genres[i], sum);

                List<Song> songs = new ArrayList<>();
                songs.add(new Song(plays[i], i));
                hashMap.put(genres[i], songs);
            }
        }

        List<String> keySets = new ArrayList<>(sumMap.keySet());
        Collections.sort(keySets, (o1, o2) -> (
                sumMap.get(o2).compareTo(sumMap.get(o1))
        ));

        Iterator<String> iterator = keySets.iterator();
        List<Integer> result = new ArrayList<>();
        while (iterator.hasNext()) {
            String key = iterator.next();
            List<Song> songs = hashMap.get(key);
            Collections.sort(songs, new Comparator<Song>() {
                @Override
                public int compare(Song o1, Song o2) {
                    return o2.plays - o1.plays;
                }
            });

            if (songs.size() == 1) result.add(songs.get(0).index);
            else {
                result.add(songs.get(0).index);
                result.add(songs.get(1).index);
            }
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < answer.length; i++)
            answer[i] = result.get(i);

        return answer;
    }

    public static class Song {
        private int plays;
        private int index;

        public Song(int plays, int index) {
            this.plays = plays;
            this.index = index;
        }
    }
}
