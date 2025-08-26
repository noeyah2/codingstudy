import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // 1. 장르별 총 재생 횟수
        HashMap<String, Integer> genrePlayCount = new HashMap<>();
        // 2. 장르별 노래 리스트
        HashMap<String, List<int[]>> genreSongs = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];

            genrePlayCount.put(genre, genrePlayCount.getOrDefault(genre, 0) + play);

            // int[] = {노래 인덱스, 재생 횟수}
            genreSongs.putIfAbsent(genre, new ArrayList<>());
            genreSongs.get(genre).add(new int[]{i, play});
        }

        // 3. 장르를 총 재생횟수 기준으로 정렬
        List<String> sortedGenres = new ArrayList<>(genrePlayCount.keySet());
        sortedGenres.sort((a, b) -> genrePlayCount.get(b) - genrePlayCount.get(a));

        List<Integer> result = new ArrayList<>();

        // 4. 각 장르별 노래 정렬 후 최대 2개 선택
        for (String genre : sortedGenres) {
            List<int[]> songs = genreSongs.get(genre);
            songs.sort((a, b) -> {
                if (b[1] == a[1]) return a[0] - b[0]; // 재생횟수 같으면 index 작은 순
                return b[1] - a[1]; // 재생횟수 내림차순
            });

            // 최대 2곡
            for (int i = 0; i < Math.min(2, songs.size()); i++) {
                result.add(songs.get(i)[0]);
            }
        }

        // int[] 변환
        return result.stream().mapToInt(i -> i).toArray();
    }
}
