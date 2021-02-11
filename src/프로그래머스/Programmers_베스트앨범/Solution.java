package 프로그래머스.Programmers_베스트앨범;

import java.util.*;

public class Solution{
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        List<Integer> result = new ArrayList<>();

        HashMap<String, List<Song>> hashMap = new HashMap<>();
        HashMap<String, Integer> answerMap = new HashMap<>();
        for(int i=0; i<genres.length; i++) {
            String key = genres[i];
            List<Song> songs = new ArrayList<>();
            if(!hashMap.containsKey(key)) {
                songs.add(new Song(plays[i], i));
                hashMap.put(key, songs);
                answerMap.put(key, plays[i]);
            }
            else {
                songs = hashMap.get(key);
                songs.add(new Song(plays[i], i));
                hashMap.put(key, songs);
                answerMap.put(key, answerMap.get(key) + plays[i]);
            }
        }

        List<String> keySetList = new ArrayList<>(answerMap.keySet());
        Collections.sort(keySetList, (o1, o2) -> (
                answerMap.get(o2).compareTo(answerMap.get(o1))
        ));

        int j = 0;
        Iterator<String> iterator = keySetList.iterator();
        while(iterator.hasNext()) {
            String key = iterator.next();
            List<Song> value = hashMap.get(key);
            Collections.sort(value, new Comparator<Song>() {
                @Override
                public int compare(Song o1, Song o2) {
                    return o2.plays - o1.plays;
                }
            });

            if(value.size() == 1) {
                result.add(value.get(0).index);
            }
            else if(value.size() > 1){
                for (int i = 0; i < 2; i++) {
                    result.add(value.get(i).index);
                }
            }
        }

        answer = new int[result.size()];
        for(int i=0; i<result.size(); i++) {
            answer[i] = result.get(i).intValue();
        }

        return answer;
    }


    class Song {
        private int plays;
        private int index;

        public Song(int plays, int index) {
            this.plays = plays;
            this.index = index;
        }
    }

}
