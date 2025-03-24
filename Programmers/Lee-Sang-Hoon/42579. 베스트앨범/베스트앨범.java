import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {

        Map<String, Integer> playCount = new HashMap<>();
        Map<String, List<Song>> GenreMap = new HashMap<>();

        for(int i = 0; i < genres.length; i++){
            String genre = genres[i];
            int play = plays[i];

            playCount.put(genre, playCount.getOrDefault(genre, 0) + play);

            GenreMap.computeIfAbsent(genre, key -> new ArrayList<>()).add(new Song(i, play));
        }

        List<String> Order = new ArrayList<>(playCount.keySet());
        Collections.sort(Order, (o1, o2) -> (playCount.get(o2) - playCount.get(o1)));

        List<Integer> answerList = new ArrayList<>();

        for(String genre : Order){
            List<Song> songList = GenreMap.get(genre);
            Collections.sort(songList, (o1, o2) -> {
                if(o1.play == o2.play){
                    return o1.index - o2.index;
                }
                return o2.play - o1.play;
            });

            for(int i = 0; i < songList.size() && i < 2; i++){
                answerList.add(songList.get(i).index);
            }
        }

        int[] answer = new int[answerList.size()];
        for(int i = 0; i < answerList.size(); i++){
            answer[i] = answerList.get(i);
        }
        return answer;
    }

    static class Song{
        int index;
        int play;

        Song(int index, int play){
            this.index = index;
            this.play = play;
        }
    }
}