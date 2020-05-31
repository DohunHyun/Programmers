import java.util.HashMap;

class Solution {

    public static void main(String[] args) {
        String[][] array = {{"yellowhat","hat"}, {"bluesunglasses","eyewear"}, {"greenhat","hat"}};
        System.out.println(solution(array));
    }

    public static int solution(String[][] clothes) {

        int answer = 0;

        HashMap map = new HashMap<String, String>();

        for(int i=0; i<clothes.length; i++) {
            map.put(clothes[i][1], (int)map.getOrDefault(clothes[i][1],0)+1);
        }

        int temp=1;

        for(Object key : map.keySet()) {
            temp *= (int)map.get(key)+1;
        }

        // 하나만 입는 경우
        answer += temp;

        return answer-1;

    }
}