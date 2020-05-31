import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Solution {
    public static void main(String[] args) {
        String[] participant = { "mislav", "stanko", "mislav", "ana" };
        String[] completion = { "stanko", "ana", "mislav" };

        // 출발 명단애들 입력하고
        // 도착 명단 애들 지워서
        // 남은애 출력.
        // 동명이인 때문에 이름을 value, key는 뭘로?

        int num = 1;
        String answer = "";

        Map<Integer, String> map = new HashMap<Integer, String>();

        for (String tmp : participant) { // 참가자 등록
            map.put(num++, tmp);
        }

        for (String tmp : completion) { // 완주자 삭제
            // 돌면서 value 값이 같은 것 찾기
            for (int i = 1; i <= num; i++) {
                if (map.get(i).equals(tmp)) {
                    map.remove(i);
                    break;
                }
            }
        }
        for (Integer key : map.keySet()) {
            answer = map.get(key);
        }

        System.out.println("hi");
        System.out.println(answer);

    }

}