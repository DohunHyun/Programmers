import java.util.*;

public class Solution {

    public static void main(String[] args) {
        System.out.println("hi");
        String[] genres = {"classic", "pop", "classic", "classic", "pop", "hiphop"};
        int[] plays = {500, 600, 150, 800, 2500, 5000};

        System.out.println(solution(genres, plays));

    }

    public static int[] solution(String[] genres, int[] plays) {
        int[] answer;
        int answersize = 0;

        HashMap<String, Integer> map = new HashMap<String, Integer>(); // genre / plays
        for (int i = 0; i < genres.length; i++) {
            map.put(genres[i], (int) map.getOrDefault(genres[i], 0) + plays[i]);
        }

        HashMap<Integer, Integer> indexMap = new HashMap<>(); // index / plays
        for (int i = 0; i < plays.length; i++) {
            indexMap.put(i, plays[i]);
        }
        // 위에서 장르별로 재생수 총합 끝. 클래식 1450, 팝 3100

        List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet()); // 장르별 재생순서 정렬

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return -o1.getValue().compareTo(o2.getValue());
            }
        });

        List<Map.Entry<Integer, Integer>> playslist = new LinkedList<>(indexMap.entrySet()); // 인덱스별 재생횟수 순위

        Collections.sort(playslist, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return -o1.getValue().compareTo(o2.getValue());
            }
        });

        // 정렬 끝.
        // 첫번째 장르에 대한 값들을 새롭게 맵에 저장. 장르가 같으면 (횟수,인덱스)로 저장.
        // 횟수 높은 순으로 정렬 후 인덱스 따로 저장.

        answer = new int[list.size() * 2];
        for (int i = 0; i < list.size(); i++) {

        }

        for (Map.Entry entry : list) { // 리스트에 순서대로 가장 많이 재생한 2곡씩 순서대로 저장.
            //entry.getkey 와 같은 장르를 가진 노래들 중에 재생수 높은애들로 저장.


            for (int i = 0; i < plays.length; i++) {
                if (genres[i].equals(entry.getKey())) { // i = 고유번호

                }
            }
        }

//        for (int j = 0; j < 2; j++) { // 두번 돌면서 장르 2개
//            Map firstmap = new HashMap<Integer, Integer>(); // 한 장르에 대한 맵 생성
//            for (int i = 0; i < genres.length; i++) {
//                if (genres[i].equals(list.get(j).getKey())) { // 장르가 1등(2등)이면
//                    firstmap.put(plays[i], i); //재생횟수와 인덱스 저장
//                }
//            }
//
//            TreeMap<Integer, Integer> treeMap = new TreeMap<>(firstmap);
//            Iterator iterator = treeMap.descendingKeySet().iterator();
//
//            int k;
//            int v;
//
//            int cycle = 2;
//            while (iterator.hasNext()) {
//                if (answersize > 3) break;
//                if (cycle == 0) break;
//                k = (int) iterator.next();
//                v = (int) treeMap.get(k);
//                answer[answersize++] = v;
//                cycle--;
//            }
//
//            for(Object value : treeMap.values()) {
//                if(answersize > 3) break;
//                if(cycle == 0) break;
//                answer[answersize++] = (int)value;
//                cycle--;
//            }
//        }

        return answer;
}

}
