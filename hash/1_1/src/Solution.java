import java.util.*;

class Solution {
    public static void main(String[] args) {
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        String answer = "";

        for(String name : participant) {
            map.put(name, map.getOrDefault(name,0) + 1);
        }

        for(String name : completion) {
            map.put(name, map.get(name) - 1);
        }

        for(String key : map.keySet()) {
            if(map.get(key) != 0) {
                answer = key;
            }
        }






    }

}