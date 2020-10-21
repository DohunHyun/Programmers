import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
        System.out.println(solution(tickets));
    }

        static List<String> list = new ArrayList<>();
        static boolean visited[];
        static String route = "";

    public static String[] solution(String[][] tickets) {

        for(int i=0; i<tickets.length; i++) {
            visited = new boolean[tickets.length];
            String from = tickets[i][0];
            String dest = tickets[i][1];

            if(from.equals("ICN")) { // 인천이면 시작 가능
                route = from + ",";
                visited[i] = true; // 갔던곳은 true 로
                dfs(tickets, dest, 1);
            }
        }

        Collections.sort(list);
        String[] answer = list.get(0).split(",");
        return answer;
    }

    private static void dfs(String[][] tickets, String dest, int cnt) {
        route += dest + ",";

        if(cnt == tickets.length) { // 모든 국가를 다 갔을때,
            list.add(route);
            return;
        }

        for(int i=0; i<tickets.length; i++) { // 다음 경로 찾기
            String f = tickets[i][0];
            String d = tickets[i][1];

            if(dest.equals(f) && !visited[i]) {
                visited[i] = true;
                dfs(tickets, d, cnt+1);
                visited[i] = false;
                route = route.substring(0, route.length()-4);
            }
        }
    }
}




