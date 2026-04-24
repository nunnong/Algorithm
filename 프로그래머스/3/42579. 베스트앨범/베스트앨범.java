import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreSum = new HashMap<>();
        Map<String, List<int[]>> genreSongs = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            genreSum.put(genres[i], genreSum.getOrDefault(genres[i], 0) + plays[i]);

            if (!genreSongs.containsKey(genres[i])) {
                genreSongs.put(genres[i], new ArrayList<>());
            }
            genreSongs.get(genres[i]).add(new int[]{i, plays[i]});
        }

        List<String> sortedGenres = new ArrayList<>(genreSum.keySet());
        sortedGenres.sort((a, b) -> genreSum.get(b) - genreSum.get(a));

        List<Integer> answerList = new ArrayList<>();
        for (String genre : sortedGenres) {
            List<int[]> songs = genreSongs.get(genre);
            songs.sort((a, b) -> {
                if (b[1] != a[1]) return b[1] - a[1];
                return a[0] - b[0];
            });

            for (int i = 0; i < Math.min(2, songs.size()); i++) {
                answerList.add(songs.get(i)[0]);
            }
        }

        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }
}