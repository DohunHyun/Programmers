public class Solution {
    public static void main(String[] args) {

        String[][] tickets = {{"ICN","SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};

//        System.out.println(solution(tickets));
//
//        if( 0 > "ICN".compareTo("SFO") ) {
//            System.out.println( "yes");
//        }


    }

    public static String[] solution(String[][] tickets) {



        int size = tickets.length;
        int inputsize = 0;
        String[] answer = new String[size+1];
        answer[0] = "ICN";
        boolean[] visited = new boolean[size]; // 기본 false
        int visit = 0;

        String dest = "";
        String from = "ICN";

        while(!visitcheck(visited)) {
            for(int j=0; j<size; j++) {
                if(!visited[j] && tickets[j][0].equals(from)) { // 출발지가 같으면
                    if(0 > tickets[j][1].compareTo(dest)) { // 이미 저장된 도착지랑 알파벳 비교
                        dest = tickets[j][1];
                        visit = j;
                    } else if(dest.equals("")) {
                        dest = tickets[j][1]; // 도착지 입력.
                        visit = j;
                    }

                }
            }
            visited[visit] = true; // 이미 쓴 티켓 표시
            from = dest; // 출발지 바꿔주고
            dest = "";
            answer[++inputsize] = from;
        }
        return answer;
    }

    private static boolean visitcheck(boolean[] visited) {
        for(boolean check : visited) {
            if(!check) { // false 이면, 즉 아직 방문안한게 있다
                return false;
            }
        }
        return true;
    }
}


