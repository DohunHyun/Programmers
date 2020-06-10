import java.util.*;

public class Solution {

    public static void main(String[] args) {
        System.out.println("hi");
        String[] genres = {"classic", "pop", "classic", "classic", "pop", "hiphop", "hiphop"};
        int[] plays = {500, 600, 150, 800, 2500, 5000, 5000};

        System.out.println(solution(genres, plays));

    }

    public static int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList();
        int size = 0;

        //장르 순서 정하기
        HashMap<String, Integer> hashMap = new HashMap();
        for(int i=0; i<genres.length; i++) {
            hashMap.put(genres[i], hashMap.getOrDefault(genres[i], 0) + plays[i]);
        }

        //장르 순서 정렬하기
        List list = new ArrayList();
        list.addAll(hashMap.keySet());
        Collections.sort(list, new Comparator<Object>() {
            public int compare(Object o1, Object o2) {
                Object v1 = hashMap.get(o1);
                Object v2 = hashMap.get(o2);

                return ((Comparable) v2).compareTo(v1);
            }
        });

        //각 장르마다 2곡씩 넣어서 만들기
        for(int i=0; i<list.size(); i++) {
            HashMap<Integer,Integer> tempHashmap = new HashMap(); //pop에 대해서 맵 만들고

            for(int j=0; j<genres.length; j++) {
                if(genres[j].equals(list.get(i))) { //장르가 pop이면
                    tempHashmap.put(j, plays[j]); //그 재생수랑 인덱스 저장
                }
            }
            //다 저장하고 정렬한다.
            List templist = new ArrayList();
            templist.addAll(tempHashmap.keySet());
            Collections.sort(templist, new Comparator<Object>() {
                public int compare(Object o1, Object o2) {
                    Object v1 = tempHashmap.get(o1);
                    Object v2 = tempHashmap.get(o2);
                    if(v1.equals(v2)) {
                        return ((Comparable<Object>) o1).compareTo(o2); //오름차순
                    } else {
                        return ((Comparable<Object>) v2).compareTo(v1); //내림차순
                    }
                }
            });


            for(int n=0; n<2; n++) {
                if(tempHashmap.size() > n) {
                    answer.add((int)templist.get(n));
                }
            }

            System.out.println();
        }


        int[] answerArray = new int[answer.size()];
        for(int temp : answer) {
            answerArray[size++] = temp;
        }
        return answerArray;
}



}
